/*
256. Paint House
https://leetcode.com/problems/paint-house/
O(N)
O(1) -> const 3 spaced array and 3 variables

DP way
*/


class Solution {
    public int minCost(int[][] costs) {
        
        int dp[] = new int[3];
        int dp0=0,dp1=0,dp2=0;
        
        for(int[] c:costs)
        {
            dp0 = c[0]+ Math.min(dp[1],dp[2]);
            dp1 = c[1]+ Math.min(dp[0],dp[2]);
            dp2 = c[2]+ Math.min(dp[0],dp[1]);
            
            dp[0] = dp0;
            dp[1] = dp1;
            dp[2] = dp2;
        }
        
        return Math.min(Math.min(dp0,dp1),dp2);
        
    }
}