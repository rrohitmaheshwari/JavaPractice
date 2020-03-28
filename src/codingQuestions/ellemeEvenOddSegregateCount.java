package codingQuestions;

import java.util.Arrays;
import java.util.List;

public class ellemeEvenOddSegregateCount {

    public static void main(String[] args) {
        System.out.println(moves(Arrays.asList(1, 2, 3)));
        System.out.println(moves(Arrays.asList( 8, 5, 11, 4, 6)));
    }

    public static int moves(List<Integer> a) {
        int[] arr = a.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int left = 0;
        int right = arr.length - 1;
        int moves = 0;
        for (int i = 0; i < arr.length; i++) {

            while (arr[left] % 2 == 0) {
                left++;
            }
            while (arr[right] % 2 == 1) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                moves++;
            }
        }
        return moves;
    }
}
