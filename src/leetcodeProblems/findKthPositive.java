/*
1539. Kth Missing Positive Number
https://leetcode.com/problems/kth-missing-positive-number/
O(N)
O(1)
*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        // if the kth missing is less than arr[0]
        if (k <= arr[0] - 1) {
            return k;
        }
        k -= arr[0] - 1;

        // search kth missing between the array numbers
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            // missing between arr[i] and arr[i + 1]
            int currMissing = arr[i + 1] - arr[i] - 1;
            // if the kth missing is between
            // arr[i] and arr[i + 1] -> return it
            if (k <= currMissing) {
                return arr[i] + k;
            }
            // otherwise, proceed further
            k -= currMissing;
        }

        // if the missing number if greater than arr[n - 1]
        return arr[n - 1] + k;
    }
}