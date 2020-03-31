package codingQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class fundingCircleEvenSum {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

        int[] A = new int[N];
        Scanner numScanner = new Scanner(s.nextLine());
        for (int i = 0; i < N; i++) {
            if (numScanner.hasNextInt()) {
                A[i] = numScanner.nextInt();
            } else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
        }

        System.out.println(summationOfNumers(A));
    }

    private static int summationOfNumers(int[] A) {
        // TODO Auto-generated method stub

        Arrays.sort(A);
        int curr = A[0];
        int sum = 0;
        int i = 0;
        int j = 1;
        while (i < j && j < A.length) {
            if (A[i] != A[j]) {
                if ((j - i) % 2 == 0) {
                    sum += A[i];
                }
                i = j;
                j++;
            } else {
                j++;
            }

        }
        return sum;
    }
}
