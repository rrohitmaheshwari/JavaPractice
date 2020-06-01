package codingQuestions;

import java.util.*;

public class vmWareEmailThreads {
    public static void main(String[] args) {
        List<String> input= new ArrayList<>();
        input.add("1@gmail.com, 2@gmail.com, Are you back from the vacation" );
        input.add("3@gmail.com, 4@gmail.com, Did you get the key" );
        input.add("2@gmail.com, 1@gmail.com, Just got in.---Are you back from the vacation" );
        input.add("1@gmail.com, 2@gmail.com, Are you asdback from the vacation" );
        System.out.println(vmWareEmailThreads.getEmailThreads(input));
    }

    public static List<List<Integer>> getEmailThreads(List<String> emails){
        List<List<Integer>> res= new ArrayList<>();

        Map<String,List<Integer>> hm = new HashMap<>();
        int globalCount = 1;

        for(String s:emails){
            int firstIndex = s.indexOf(',');
            int secondIndex = s.indexOf(',',firstIndex+1);
            String emailOne = s.substring(0,firstIndex).trim();
            String emailTwo = s.substring(firstIndex+1,secondIndex).trim();
            if(emailOne.compareTo(emailTwo) < 0){
                String temp = emailTwo;
                emailTwo = emailOne;
                emailOne = temp;
            }
            String messageBody = s.substring(secondIndex+1).trim();
            String[] messages = messageBody.split("---");
            String key = emailOne+"#"+emailTwo+"#"+messages[messages.length-1];
            if(hm.containsKey(key)){
                List<Integer> hmList = hm.get(key);
                List<Integer> newHmList = Arrays.asList(hmList.get(0),hmList.get(1)+1);
                res.add(Arrays.asList(hmList.get(0),hmList.get(1)+1));
                hm.put(key,newHmList);
            }
            else{
                List<Integer> newHmList = Arrays.asList(globalCount,1);
                res.add(Arrays.asList(globalCount,1));
                hm.put(key,newHmList);
                globalCount++;
            }
        }

      return res;
    }

}
