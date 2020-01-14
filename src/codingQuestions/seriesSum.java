package codingQuestions;

import java.util.Arrays;

public class seriesSum {
    public static void main(String[] args) {
        System.out.println(ways(842, 91));
        System.out.println(ways(619, 99));
    }

    public static int ways(int total, int k) {

            double table[] = new double[total + 1];
            table[0] = 1;

            int arr[] = new int[k];

            for (int i = 1; i <= k; i++) {
                arr[i - 1] = i;
            }

            for (int i = 0; i < arr.length; i++)
                for (int j = arr[i]; j <= total; j++)
                    table[j] = (table[j]  + table[j - arr[i]]) % 1000000007;

            return (int) (table[total] % 1000000007);

    }

}
