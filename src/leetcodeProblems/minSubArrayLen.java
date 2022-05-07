/*
209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/
O(N)
O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minSizeSum = Integer.MAX_VALUE;
        int start=0;
        
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            
            while(sum>=target && start<=i)
            {
                //reduce window
                minSizeSum = Math.min(minSizeSum,i-start+1);
                sum -= nums[start];
                start++;
            }
        }
        
        return minSizeSum == Integer.MAX_VALUE?0:minSizeSum;
    }
}