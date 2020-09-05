package codingQuestions;

import java.util.*;

public class AmazonTopK {

    public static void main(String[] args) {
        AmazonTopK a = new AmazonTopK();
        int k = 5;

        //Assuming we have every minute one entry
        Prod inputStream[] = new Prod[]{
                new Prod(1, 5, 1),
                new Prod(2, 5, 2),
                new Prod(1, 1, 3)
        };
        for (Prod p : inputStream)
            System.out.print(p);
        System.out.println("\n-------------");
        a.invoke(inputStream, k);

    }

    public void invoke(Prod inputStream[], int k) {
        // set up
        HashMap<Integer, Prod> inTopK = new HashMap<>();
        HashMap<Integer, Prod> notTopK = new HashMap<>();

        List<Prod> topK = new ArrayList<>();

        for (int i = 0; i < inputStream.length; i++) {
            Prod p = inputStream[i];
            if (topK.size() < k) {
                Prod temp = inTopK.getOrDefault(p.pid, new Prod(p.pid, 0, p.time));
                temp.cnt += p.cnt;
                inTopK.put(p.pid, p);

                // modify this section to use your custom binary search and then edit that entry and readjust list
                if (temp.cnt == p.cnt) {
                    topK.add(temp);
                } else {
                    for (Prod lp : topK) {
                        if (lp.pid == temp.pid) {
                            lp.cnt = temp.cnt;
                            break;
                        }
                    }
                }
                Collections.sort(topK, Comparator.comparing(Prod::getCnt).reversed().thenComparing(Prod::getTime));
                System.out.println(topK);
            } else { // k is full so we need to add element (may or may not be new) or remove element (count) which is gone inputStream[i-5]

                //is element in already top k?
                if (inTopK.containsKey(p.pid)) {

                } else { //element must not be in top k


                }
            }

        }
    }

}


class Prod {
    int pid;
    int cnt;
    int time; //in min

    public Prod(int pid, int cnt, int time) {
        this.pid = pid;
        this.cnt = cnt;
        this.time = time;
    }

    public int getPid() {
        return pid;
    }

    public int getCnt() {
        return cnt;
    }

    public int getTime() {
        return time;
    }

    public String toString() {//overriding the toString() method
        return "[" + pid + "," + cnt + "," + time + "] ";
    }

}
