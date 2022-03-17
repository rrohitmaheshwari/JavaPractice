/*
31. Next Permutation
https://leetcode.com/problems/next-permutation/
*/

class Solution {
    public void nextPermutation(int[] nums) {
        /*
        13452
        13524
        */
        
   int i = nums.length - 2;
        
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        // swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // reverse remaining
        i++;
        
        int end = nums.length - 1;
        while (i < end) {
            swap(nums, i, end);
            i++;
            end--;
        }
    }



    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}