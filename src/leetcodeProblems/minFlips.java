/*
1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
O(N*N*2^N)
O(N)

Copied from leetcode
*/

class Solution {
    
    public int minFlips(int[][] mat) {
        int M = mat.length, N = mat[0].length;
        int res = helper(mat, M, N, new HashSet<>(), new HashMap<>());
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public int helper(int[][] mat, int M, int N, Set visited, Map memo) {
        
        if (check(mat, M, N)) return 0;
        
        String state = "";
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                state += mat[i][j];
        
        if (memo.containsKey(state)) 
            return memo.get(state);
        
        if (visited.contains(state)) // found cycle
            return Integer.MAX_VALUE;
        
        visited.add(state);
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                flip(mat, i, j, M, N);  //flip
                
                int small = helper(mat, M, N, visited, memo);
                
                if (small != Integer.MAX_VALUE) 
                    min = Math.min(min, 1 + small);
                
                flip(mat, i, j, M, N);  // flip back
            }
        }
        
        visited.remove(state);  // backtrack
        
        memo.put(state, min);
        return min;
    }
    
    public boolean check(int[][] mat, int n, int m) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 1) return false;
        return true;
    }
    
    private void flip(int[][] mat, int i, int j, int M, int N) {
        mat[i][j] = mat[i][j] ^ 1;
        if (i - 1 >= 0) mat[i - 1][j] = mat[i - 1][j] ^ 1;
        if (i + 1 < M) mat[i + 1][j] = mat[i + 1][j] ^ 1;
        if (j - 1 >= 0) mat[i][j - 1] = mat[i][j - 1] ^ 1;
        if (j + 1 < N) mat[i][j + 1] = mat[i][j + 1] ^ 1;
    }
}