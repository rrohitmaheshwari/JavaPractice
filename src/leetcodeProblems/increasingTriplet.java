/*
334. Increasing Triplet Subsequence
https://leetcode.com/problems/increasing-triplet-subsequence/
O(N)
O(1)
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
           int first_num = Integer.MAX_VALUE;
           int second_num = Integer.MAX_VALUE;
        
       for (int n: nums) {
                if (n <= first_num) {
                    first_num = n;
                } else if (n <= second_num) {
                    second_num = n;
                } else { // found 3rd numder which is larger than both
                    return true;
                }
            }
        return false;
        
    }
}