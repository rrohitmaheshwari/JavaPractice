/*
189. Rotate Array
https://leetcode.com/problems/rotate-array/
O(N)
O(1)
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
    reverse(nums, 0, nums.length - 1); //reverse all
    reverse(nums, 0, k - 1); // reverse 1st k
    reverse(nums, k, nums.length - 1); // reverse last len-k
    }
    
      public void reverse(int[] nums, int start, int end) 
      {
        while (start < end) {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
        }
      }
}