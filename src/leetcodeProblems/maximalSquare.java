/*
221. Maximal Square
https://leetcode.com/problems/maximal-square/
O(N*M)
O(N*M) --> can be further optimized as O(M) -> collumn
*/


public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length,
        cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        
        int maxsqlen = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) 
            {
                if (i == 0 || j == 0) 
                {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                } 
                else if (matrix[i][j] == '1') 
                {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
            }
        }
    }
    return maxsqlen * maxsqlen;
    }
}

// Space Optimized sol

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, 
        cols = matrix[0].length;

        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}