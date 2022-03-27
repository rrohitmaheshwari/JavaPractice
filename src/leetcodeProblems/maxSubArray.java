/*
53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/
O(N)
O(1)
*/
class Solution {
    // kandane's algorithm
    public int maxSubArray(int[] nums) {
        int max= Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            max=Math.max(max,sum);
            
            // resetting sum if sum<0
            if(sum<0)
            {
                sum=0;
            }
        }
        
        return max;
    }
}