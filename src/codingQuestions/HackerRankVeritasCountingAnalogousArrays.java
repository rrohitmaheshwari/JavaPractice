package codingQuestions;

import java.util.Arrays;
import java.util.List;

public class HackerRankVeritasCountingAnalogousArrays {

    public static void main(String[] args) {
        System.out.println(countAnalogousArrays(Arrays.asList(-2, -1, -2, 5), 3, 10));
        System.out.println(countAnalogousArrays(Arrays.asList(-1, -3, 2), 2, 8));
    }

    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {

        long res = 0;

        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i : consecutiveDifference) {
            sum += (long) i;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }


        long diff = max - min;

        if (max < 0 && min < 0) {
            diff++;
        }

        lowerBound += diff;

        res = upperBound - lowerBound + 1;


        if (res > 0)
            return (int) res;
        else
            return 0;

    }
}
