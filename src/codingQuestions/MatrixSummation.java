package codingQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSummation {

    public static void main(String[] args) {

        List<List<Integer>> after = new ArrayList<>();
        after.add(Arrays.asList(2, 5));
        after.add(Arrays.asList(7, 17));
//        List<List<Integer>> res = findBeforeMatrix(after);
//[[2, 3], [5, 7]]


        System.out.println(findBeforeMatrix(after));

        List<List<Integer>> after2 = new ArrayList<>();
        after2.add(Arrays.asList(1, 3));
        after2.add(Arrays.asList(4, 10));
        System.out.println(findBeforeMatrix(after2));

        //[[1, 2], [3, 4]]

        List<List<Integer>> after3 = new ArrayList<>();
        after3.add(Arrays.asList(1, 2));
        after3.add(Arrays.asList(3, 4));
        System.out.println(findBeforeMatrix(after3));

        //[[1, 1], [2, 0]]

        List<List<Integer>> after4 = new ArrayList<>();
        after4.add(Arrays.asList(26, 26, 33, 13, 88, 61, 44, 58, 45));
        after4.add(Arrays.asList(9, 7, 90, 36, 15, 20, 76, 44, 5));
        after4.add(Arrays.asList(19, 28, 64, 92, 10, 93, 53, 38, 26));
        after4.add(Arrays.asList(32, 87, 28, 98, 86, 70, 30, 3, 44));
        after4.add(Arrays.asList(61, 22, 20, 18, 50, 96, 2, 36, 1));
        System.out.println(after4);
        System.out.println(findBeforeMatrix(after4));

    }

    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {

        int row = after.size();
        int col = after.get(0).size();

        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if (i == 0 && j == 0) {
                    after.get(i).set(j, after.get(i).get(j));
                } else if (i - 1 >= 0 && j - 1 >= 0) {
                    after.get(i).set(j, after.get(i).get(j) - after.get(i - 1).get(j) - after.get(i).get(j - 1) + after.get(i - 1).get(j - 1));

                } else if (i - 1 < 0) {
                    after.get(i).set(j, after.get(i).get(j) - after.get(i).get(j - 1));
                } else if (j - 1 < 0) {
                    after.get(i).set(j, after.get(i).get(j) - after.get(i - 1).get(j));
                }
            }
        }
        return after;
    }
}
