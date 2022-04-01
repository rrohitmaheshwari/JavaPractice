/*
300. Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/
O(N*N)
O(N) - dp array
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int dp [] = new int[nums.length];
        Arrays.fill(dp,1); // base case
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j]) // got increasing number
                {
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        int maxLen = 0;
        for(int n:dp)
        {
            maxLen = Math.max(maxLen,n);
        }
        
        return maxLen;
        
    }
}