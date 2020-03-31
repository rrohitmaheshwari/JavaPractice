package codingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class HackerRankCerealSegments {
    public static void main(String[] args) {
        System.out.println(segment(2, Arrays.asList(8, 2, 4)));
        System.out.println(segment(3, Arrays.asList(2, 5, 4, 6, 8)));
//        System.out.println(segment2(3, Arrays.asList(11, 2, 5, 4, 6, 8,4)));
    }

    private static int segment(int x, List<Integer> arr) {

        int n = arr.size();

        Stack<Integer> s = new Stack<>();


        int left[] = new int[n + 1];
        int right[] = new int[n + 1];


        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr.get(s.peek()) >= arr.get(i))
                s.pop();

            if (!s.empty())
                left[i] = s.peek();

            s.push(i);
        }

        while (!s.empty())
            s.pop();


        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr.get(s.peek()) >= arr.get(i))
                s.pop();

            if (!s.empty())
                right[i] = s.peek();

            s.push(i);
        }


        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; i++)
            ans[i] = 0;


        for (int i = 0; i < n; i++) {

            int len = right[i] - left[i] - 1;

            ans[len] = Math.max(ans[len], arr.get(i));
        }

        for (int i=n-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);

        return ans[x];



    }

//    public static int segment2(int x, List<Integer> arr) {
//        if(arr == null || arr.isEmpty()) return Integer.MAX_VALUE;
//
//        PriorityQueue<Integer> pq = new PriorityQueue();
//
//        for(Integer i: arr) pq.add(i);
//
//        int numOfSubArray = (arr.size()/x) + 1;
//        Integer max = Integer.MIN_VALUE;
//        int count = 0;
//        while(!pq.isEmpty() && count < numOfSubArray) {
//            Integer k = pq.poll();
//            if(k > max) max = k;
//            count++;
//        }
//
//        return max.intValue();
//    }
}
