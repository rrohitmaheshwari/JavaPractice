/*
72. Edit Distance
https://leetcode.com/problems/edit-distance/

O(NM)
O(NM)

Copied from https://leetcode.com/problems/edit-distance/discuss/25895/Step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-DP

*/

public class Solution {
    /**
     * Optimization using dynamic programming
     * Top-down solution
     * O(len1 * len2) time, O(len1 * len2) space
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        
        int[][] cache = new int[c1.length][c2.length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                cache[i][j] = -1;
            }
        }
        
        return match(c1, c2, 0, 0, cache);
    }
    
    private int match(char[] c1, char[] c2, int i, int j, int[][] cache) {
        if (c1.length == i) return c2.length - j;
        if (c2.length == j) return c1.length - i;
        
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        
        if (c1[i] == c2[j]) {
            cache[i][j] = match(c1, c2, i + 1, j + 1, cache);
        } else {
            //Case1: insert
            int insert = match(c1, c2, i, j + 1, cache);
            //Case2: delete
            int delete = match(c1, c2, i + 1, j, cache);
            //Case3: replace
            int replace = match(c1, c2, i + 1, j + 1, cache);
            
            cache[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
        }
        
        return cache[i][j];
    }
}