package codingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class beautifulRows {

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 17, 4, 12, 5, 6, 2, 1};
        int[] arr = new int[]{1,1,1,1,1};

        System.out.println("----->Input : " + Arrays.toString(arr));

        int n = 8;
        System.out.println(minNum(arr, arr.length));


    }

    public static int minNum(int arr[], int n) {

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length - 1; i++) {

            int[] leftArray = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                leftArray[j] = arr[j];
            }


            int lcount = i - Find_Sequence_left(leftArray, leftArray.length);

            int[] rightArray = new int[arr.length - i];

            for (int j = i; j < arr.length; j++) {
                rightArray[j - i] = arr[j];
            }


            int rcount = arr.length - i - Find_Sequence_right(rightArray, rightArray.length);

            if (min > (lcount + rcount)) {
                min = lcount + rcount;

            }


        }


        return min;
    }


    public static int Find_Sequence_left(int arr[], int n) {

        List<Integer> inc_arr, dec_arr;
        inc_arr = new ArrayList<>();
        dec_arr = new ArrayList<>();


        int inc = -1, dec = Integer.MAX_VALUE;


        for (int i = 0; i < n - 1; i++) {

            if (inc < arr[i] && arr[i] < dec) {

                if (arr[i] < arr[i + 1]) {
                    inc = arr[i];
                    inc_arr.add(arr[i]);
                } else {
                    dec = arr[i];
                    dec_arr.add(arr[i]);
                }
            } else if (inc < arr[i]) {
                inc = arr[i];
                inc_arr.add(arr[i]);
            } else if (dec > arr[i]) {
                dec = arr[i];
                dec_arr.add(arr[i]);
            } else {

                return 0;

            }
        }


        return inc_arr.size();
    }


    public static int Find_Sequence_right(int arr[], int n) {
        List<Integer> inc_arr, dec_arr;
        inc_arr = new ArrayList<>();
        dec_arr = new ArrayList<>();


        int inc = -1, dec = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (inc < arr[i] && arr[i] < dec) {

                if ((i + 1) != n && arr[i] < arr[i + 1]) {
                    inc = arr[i];
                    inc_arr.add(arr[i]);
                } else {
                    dec = arr[i];
                    dec_arr.add(arr[i]);
                }
            } else if (inc < arr[i]) {
                inc = arr[i];
                inc_arr.add(arr[i]);
            } else if (dec > arr[i]) {
                dec = arr[i];
                dec_arr.add(arr[i]);
            } else {

                return 0;

            }
        }

        return dec_arr.size();
    }
}
