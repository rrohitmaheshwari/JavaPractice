/*
542. 01 Matrix
https://leetcode.com/problems/01-matrix/
O(N)
O(1)

DP solution
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int INF = R*C; // max distance possible
        
        
        // parse this from top left
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(mat[i][j]==1)
                {
                    int top=INF,left=INF; // borders;
                    
                    if (i - 1 >= 0) 
                         top = mat[i - 1][j];
                    if (j - 1 >= 0)
                        left = mat[i][j - 1];
                    
                    mat[i][j] = Math.min(top+1,left+1);
                }
            }
        }
        
        //parse this from bottom right
        
        for(int i=R-1;i>=0;i--)
        {
            for(int j=C-1;j>=0;j--)
            {
                if(mat[i][j] == 0)
                {
                    continue;
                }
                
                 int bottom=INF,right=INF; // borders;
                
                if(i + 1 < R)
                {
                    bottom = mat[i+1][j];
                }
                if(j + 1 < C)
                {
                    right = mat[i][j+1];
                }
                
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom+1,right+1));
                
            }
        }
        
        return mat;
        
    }
}