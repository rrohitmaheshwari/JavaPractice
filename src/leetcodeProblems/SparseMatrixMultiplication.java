/*
311. Sparse Matrix Multiplication
O(NKM)
O(1)
*/
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;
        
        // Product matrix will have 'n x m' size.
        int[][] ans = new int[n][m];
        
        for (int i = 0; i < n; ++i) 
        {
            for (int j = 0; j < m; ++j) 
            {
                    for (int l = 0; l < k; ++l) 
                    {
                        ans[i][j] += 
                            mat1[i][l] 
                            * mat2[l][j];
                    }
            }
        }
        
        return ans;
        
    }
}