/*
97. Interleaving String
https://leetcode.com/problems/interleaving-string/
O(MN)
O(MN) - cache and call stack

*/


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return areInterleave(s1, s2, s3, 0, 0, cache);
    }
    
    
    private static boolean areInterleave(String one, String two, String three, int i, int j,
                                         Boolean[][] cache) 
    {
        if (cache[i][j] != null) 
        {
            return cache[i][j];
        }
        
        int k = i + j;

        if (k == three.length()) // completed all chars in target
        {
            return true;
        }

        if ((i < one.length()) && (one.charAt(i) == three.charAt(k))) 
        {
            cache[i][j] = areInterleave(one, two, three, i + 1, j, cache);
            
            if (cache[i][j]) 
            {
                return true;
            }
        
        }

        if ((j < two.length()) && (two.charAt(j) == three.charAt(k))) 
        {
            cache[i][j] = areInterleave(one, two, three, i, j + 1, cache);
            
            if (cache[i][j]) 
            {
                return true;
            }
        }
        
        cache[i][j] = false;
        return false;
    }
}




// DP way: Diagram at: https://leetcode.com/problems/interleaving-string/solution/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}