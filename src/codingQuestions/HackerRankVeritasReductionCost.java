package codingQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HackerRankVeritasReductionCost {
    public static void main(String[] args) {

//        System.out.println(reductionCost(Arrays.asList(1, 2, 3, 4)));
        System.out.println(reductionCost(Arrays.asList(4, 4, 4, 4, 6)));
        // 8,4,4,6  =>

    }

    private static int reductionCost(List<Integer> num) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(num);

        int curr;
        int cost = 0;

        while (pq.size() != 1) {
            curr = pq.poll() + pq.poll();
            cost += curr;
            pq.add(curr);
        }

        return cost;

    }


}
