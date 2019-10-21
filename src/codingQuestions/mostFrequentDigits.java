package codingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mostFrequentDigits {

    public static void main(String[] args) {

//        int[] a = {1, 2};
        int[] a = {25, 2, 3, 57, 38, 41};

        mostFrequentDigits(a);

    }

    static int[] mostFrequentDigits(int[] a) {
        List<Integer> res = new ArrayList<>();
        int[] ref = new int[10];

        for (int i : a) {
            while (i != 0) {
                ref[i % 10]++;
                i = i / 10;
            }
        }


        int max = Arrays.stream(ref)
                .max()
                .getAsInt();

        int j = 0;
        for (int i : ref) {

            if (i == max) {
                res.add(j);
            }
            j++;
        }


        return res.stream().mapToInt(i -> i).toArray();
    }
}

