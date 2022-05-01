/*
877. Stone Game
https://leetcode.com/problems/stone-game/
O(N^2) - number of visited elements is dp arrays size
O(N^2) - dp array

Memonization solution
Ref: https://www.youtube.com/watch?v=YVmTjwBjYwo

*/

class Solution {
    public boolean stoneGame(int[] piles) {
        int dp[][] = new int[piles.length][piles.length];
        
        for(int i=0;i<piles.length;i++)
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        
        return helper(0,piles.length-1,piles,dp)>0;
    }
    
    int helper(int l,int r, int piles[],int dp[][])
    {
        if(l>r)
            return 0;
        if(dp[l][r]!=Integer.MIN_VALUE)
        {
            return dp[l][r];
        }
        
        dp[l][r] =  Math.max(piles[l] - helper(l+1,r,piles,dp) , piles[r] - helper(l,r-1,piles,dp));
        return dp[l][r];
    }
}


// DP way

 public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];

       // fill up the diagnonal
        for (int i = 0; i < n; i++) 
        	dp[i][i] = p[i];


        // go diagonal wise
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d]
                	, p[i + d] - dp[i][i + d - 1]);


        return dp[0][n - 1] > 0;
    }