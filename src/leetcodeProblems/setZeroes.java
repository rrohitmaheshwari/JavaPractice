/*
73. Set Matrix Zeroes
https://leetcode.com/problems/set-matrix-zeroes/solution/
O(NM)
O(1)
*/
 class Solution {
    public void setZeroes(int[][] matrix) {
       
        int m = matrix.length; // No of rows
        int n = matrix[0].length; // No of columns

        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0)
                isFirstRowZero = true;
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                isFirstColumnZero = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;
        }

        if (isFirstColumnZero) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
        
    }
}

