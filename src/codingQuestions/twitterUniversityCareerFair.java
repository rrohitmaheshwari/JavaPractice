package codingQuestions;

import java.util.*;

public class twitterUniversityCareerFair {

    public static void main(String[] args) {

//        System.out.println(maxEvents(Arrays.asList(1, 3, 3, 5, 7), Arrays.asList(2, 2, 1, 2, 1)));
        System.out.println(maxEvents(Arrays.asList(1, 3, 5), Arrays.asList(2, 2, 2)));
        System.out.println(maxEvents(Arrays.asList(250, 74, 659, 931, 273, 545, 879), Arrays.asList(924, 710, 441, 166, 493, 43, 988)));

    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        int[][] event = new int[arrival.size()][2];
        for (int i = 0; i < arrival.size(); i++) {
            event[i][0] = arrival.get(i);
            event[i][1] = arrival.get(i) + duration.get(i);

        }

        Arrays.sort(event, (a, b) -> (a[1] - b[1]));
//        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<int[]> l = new ArrayList<>();
        int cnt = 0;
        int[] first = event[0];
        for (int i = 1; i < event.length; i++) {
            int[] cur = event[i];
            if (cur[0] < first[1]) {
//                minHeap.offer(cur);s
                cnt++;
                l.add(cur);
            } else {
                first[1] = event[i][1];
            }
        }

//        return arrival.size() - minHeap.size();
        return arrival.size() - cnt;

    }
}

