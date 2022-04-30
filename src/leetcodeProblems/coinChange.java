/*
322. Coin Change
https://leetcode.com/problems/coin-change/solution/

O(S*N) ->  S is target and N is number of coins
O(S) -> DP array

DP bottom up approach

Diagram and explaination:
https://www.youtube.com/watch?v=H9bfqozjoqs

*/

public class Solution {
  public int coinChange(int[] coins, int amount) {
      
    int max = amount + 1; // Or we could use Integer.Max value
      
    int[] dp = new int[amount + 1];
      
    Arrays.fill(dp, max);
      
    dp[0] = 0;
      
    for (int i = 1; i <= amount; i++) 
    {
      for (int j = 0; j < coins.length; j++) 
      {
        if (i - coins[j] >= 0) // as we are using dp inside that comparision
        {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
      
    return dp[amount] > amount ? -1 : dp[amount];
  }
}