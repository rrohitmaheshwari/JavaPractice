package codingQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class maxDifference {

    public static void main(String[] args) {


        System.out.println(maxDifference(Arrays.asList(7, 5, 3, 1)));
        System.out.println(maxDifference(Arrays.asList(7, 1, 2, 5)));
        System.out.println(maxDifference(Arrays.asList(7, 9, 5, 6, 3, 2)));
        System.out.println(maxDifference(Arrays.asList(2, 3, 10, 2, 4, 8, 1)));
    }

    public static int maxDifference(List<Integer> nums) {
        int diff = nums.get(1) - nums.get(0);
        int min = nums.get(0);


        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) - min > diff)
                diff = nums.get(i) - min;
            if (nums.get(i) < min)
                min = nums.get(i);
        }
        if (diff > 0)
            return diff;
        else
            return -1;
    }
}
