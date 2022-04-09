/*
561. Array Partition I
https://leetcode.com/problems/array-partition-i/
O(NLogN)
O(1)
*/

class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int minSum = 0;
        
        for(int i=0;i<nums.length;i=i+2)
        {
            minSum+=nums[i];
        }
        return minSum;
    }
}