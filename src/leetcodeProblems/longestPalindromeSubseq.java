/*
516. Longest Palindromic Subsequence
https://leetcode.com/problems/longest-palindromic-subsequence/
O(N^2) where N is len of String
O(N)
*/

public class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
              // actual string, left, right,cache
    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) 
        {
            return memo[i][j];
        }
        if (i > j)      
            return 0;
        
        if (i == j)     // pointing so same char
            return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2; // taking two char
        } 
        else // no match so do not consider any count
        {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo)  // ignoring from each side 
                                  , helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
/*  ACTUAL DP CODE
     public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
    */
}