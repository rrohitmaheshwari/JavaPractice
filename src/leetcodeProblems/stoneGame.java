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