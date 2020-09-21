package codingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rubulaxSlowestkey {

    public static void main(String[] args) {
//        List<List<Integer>> keyTimes = new ArrayList<>();
//        keyTimes.add(Arrays.asList(0,2));
//        keyTimes.add(Arrays.asList(1,5));
//        keyTimes.add(Arrays.asList(0,9));
//        keyTimes.add(Arrays.asList(2,15));
//        System.out.println(slowestKey(keyTimes));
//
//        List<List<Integer>> keyTimes2 = new ArrayList<>();
//        keyTimes2.add(Arrays.asList(0,2));
//        keyTimes2.add(Arrays.asList(1,3));
//        keyTimes2.add(Arrays.asList(0,7));
//        System.out.println(slowestKey(keyTimes2));
//
//        List<List<Integer>> keyTimes3 = new ArrayList<>();
//        keyTimes3.add(Arrays.asList(0,1));
//        keyTimes3.add(Arrays.asList(0,3));
//        keyTimes3.add(Arrays.asList(4,5));
//        keyTimes3.add(Arrays.asList(5,6));
//        keyTimes3.add(Arrays.asList(4,10));
//
//        System.out.println(slowestKey(keyTimes3));

        List<List<Integer>> keyTimes4 = new ArrayList<>();
        keyTimes4.add(Arrays.asList(0, 3));
        keyTimes4.add(Arrays.asList(20, 5));
        keyTimes4.add(Arrays.asList(2, 6));
        keyTimes4.add(Arrays.asList(15, 7));
        keyTimes4.add(Arrays.asList(9, 8));
        keyTimes4.add(Arrays.asList(19, 9));
        keyTimes4.add(Arrays.asList(24, 10));
        keyTimes4.add(Arrays.asList(4, 12));
        keyTimes4.add(Arrays.asList(3, 13));
        System.out.println(slowestKey(keyTimes4));
    }

    public static char slowestKey(List<List<Integer>> keyTimes) {
        int size = keyTimes.size();
        int max = keyTimes.get(0).get(1);
        int temp = max;
        int ch = keyTimes.get(0).get(0);

        for (int i = 1; i < size; i++) {
            List<Integer> l = keyTimes.get(i);
            temp = keyTimes.get(i).get(1) - keyTimes.get(i - 1).get(1);
            if (temp > max) {
                max = temp;
                ch = keyTimes.get(i).get(0);
            }
        }
        return (char) ('a' + ch);

    }
}

