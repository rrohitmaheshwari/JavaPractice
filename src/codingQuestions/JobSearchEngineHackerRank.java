package codingQuestions;

import org.w3c.dom.Node;

import java.util.*;

public class JobSearchEngineHackerRank {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int myInput = scanner.nextInt();
//        String[] input = new String[myInput];
//        int i = 0;
//        while (i <= myInput) {
//            input[i] = scanner.nextLine();
//            i++;
//        }

        //ADD type user-id job-id
        //QUERY user-id
        //COMPLETE user-id job-id
        //EXPIRE job-id

        String[] input = {"ADD apply 1 10",
                "ADD respond 1 10",
                "ADD interview 1 10",
                "QUERY 1",
                "COMPLETE 1 10",
                "QUERY 1",
                "ADD foo 2 20",
                "ADD bar 2 10",
                "QUERY 2",
                "EXPIRE 10",
                "QUERY 1",
                "QUERY 2",
                "ADD baz 1 10",
                "QUERY 1"
        };

        helper(input);
        System.out.println(getResult(input));

    }


    static void helper(String[] input) {

        Map<String, User> userHashMap = new HashMap<>();
        Map<String, List<User>> jobToUserHashMap = new HashMap<>();

        for (String sInput : input) {
            String[] s = sInput.split(" ");


            //ADD type user-id job-id
            if (s[0].equals("ADD")) {
                User temp = userHashMap.getOrDefault(s[2], new User());
                temp.job.add(new TypeJobId(s[1], s[3]));
                userHashMap.put(s[2], temp);

                List<User> uTemp = jobToUserHashMap.getOrDefault(s[0], new ArrayList<User>());
                uTemp.add(userHashMap.get(s[2]));
                jobToUserHashMap.put(s[0], uTemp);

            } else if (s[0].equals("QUERY")) {    //QUERY user-id


                if (userHashMap.containsKey(s[1])) {
                    User temp = userHashMap.get(s[1]);
                    temp.peekTop(s[1]);

                } else {
                    System.out.println("No result");
                }


            } else if (s[0].equals("COMPLETE")) {  //COMPLETE user-id job-id

                if (userHashMap.containsKey(s[1])) {
                    User temp = userHashMap.get(s[1]);
                    temp.complete(s[1], s[2]); //check for no result


                } else {
                    System.out.println("No result");
                }


            } else if (s[0].equals("EXPIRE")) {//EXPIRE job-id


                for (Map.Entry<String, User> entry : userHashMap.entrySet()) {
                    User temp = entry.getValue();
                    temp.expire(s[1]);
                }

            }

        }

    }


    static class User {

        List<TypeJobId> job = new ArrayList<>();

        void peekTop(String userID) {
            if (job.size() == 0) {
                System.out.println("No result");
                return;
            }

            Collections.sort(job, (node1, node2) ->
                    Long.compare(Long.parseLong(node1.jobId), Long.parseLong(node2.jobId))
            );
            System.out.println("Next step for user " + userID + ":");


            System.out.println("    " + job.get(0).jobId + " " + job.get(0).type);
            for (int i = 1; i < job.size(); i++) {
                if (!job.get(i).jobId.equals(job.get(i - 1).jobId))
                    System.out.println("    " + job.get(i).jobId + " " + job.get(i).type);
            }

        }

        void complete(String userID, String jobId) {

            List<TypeJobId> jobNew = new ArrayList<>();
            String type = "#";
            boolean flag = true;
            for (TypeJobId j : job) {
                if (flag && j.jobId.equals(jobId)) {
                    type = j.type;
                    flag = false;
                } else {
                    jobNew.add(j);
                }
            }
            this.job = jobNew;
            if (type.equals("#")) {
                System.out.println("No result");
            } else {
                System.out.println("User " + userID + " completed " + type + " for job " + jobId);
            }

        }

        void expire(String s) {
            List<TypeJobId> jobNew = new ArrayList<>();
            for (TypeJobId j : job) {
                if (j.jobId.equals(s)) {

                } else {
                    jobNew.add(j);
                }
            }
            this.job = jobNew;


        }
    }

    static class TypeJobId {
        String type;
        String jobId;

        TypeJobId(String type, String jobId) {
            this.type = type;
            this.jobId = jobId;
        }
    }

    private static List<String> getResult(String[] input) {

        List<String> result = new ArrayList<>();
        Map<Long, Map<Long,JobQueue>> userMap = new HashMap<>();
        Set<Long> expiredJobs = new HashSet<>();

        for(int i=0;i<input.length;i++)
        {
            String[] in = input[i].split(" ");
            if(input[i].startsWith("ADD"))
            {

                userMap.putIfAbsent(Long.parseLong(in[2]), new HashMap<>());

                userMap.get(Long.parseLong(in[2])).putIfAbsent(Long.parseLong(in[3]), new JobQueue());
                if(expiredJobs.contains(Long.parseLong(in[3])))
                {
                    userMap.get(Long.parseLong(in[2])).get(Long.parseLong(in[3])).status.clear();

                }
                userMap.get(Long.parseLong(in[2])).get(Long.parseLong(in[3])).status.add(in[1]);


                if(expiredJobs.contains(Long.parseLong(in[3])))
                {
                    expiredJobs.remove(Long.parseLong(in[3]));
                }

            }
            else if(input[i].startsWith("QUERY"))
            {
                List<Long> curr= new ArrayList<>();

                if(userMap.containsKey(Long.parseLong(in[1])))
                {
                    result.add("Next steps for user "+ in[1]+ ":");
                    for (Map.Entry<Long, JobQueue> entry : userMap.get(Long.parseLong(in[1])).entrySet())
                    {
                        if(!expiredJobs.contains(entry.getKey()))
                        {
                            curr.add(entry.getKey());
                        }
                    }

                    if(curr.size()==0)
                    {
                        result.remove(result.size()-1);

                    }
                    else
                    {
                        Collections.sort(curr);

                        for(int j=0;j<curr.size();j++)
                        {
                            result.add(curr.get(j)+" "+userMap.get(Long.parseLong(in[1])).get(curr.get(j)).status.peek());
                        }
                        continue;
                    }

                }

                result.add("No result");


            }
            else if(input[i].startsWith("COMPLETE"))
            {
                if(!expiredJobs.contains(Long.parseLong(in[2])))
                {
                    if(userMap.containsKey(Long.parseLong(in[1])))
                    {
                        if(userMap.get(Long.parseLong(in[1])).containsKey(Long.parseLong(in[2])))
                        {
                            if(!userMap.get(Long.parseLong(in[1])).get(Long.parseLong(in[2])).status.isEmpty())
                            {
                                result.add("User "+in[1]+" completed "+ userMap.get(Long.parseLong(in[1])).get(Long.parseLong(in[2])).status.poll()+" for job "+ in[2]);
                            }
                        }
                    }
                }
            }
            else if(input[i].startsWith("EXPIRE"))
            {
                expiredJobs.add(Long.parseLong(in[1]));
            }

        }

        return result;
    }

    static class JobQueue
    {
        Queue<String> status;

        public JobQueue() {
            status= new LinkedList<>();
        }
    }
}
