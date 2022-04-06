/*
74. Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/
O(N)
O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0)
            return false;
        
        if(m*n == 1)
        {
            if(matrix[0][0] == target)
                return true;
            return false;
        }
        
        int first=0;
        int last = m*n-1;
        
        while(first<=last)
        {
            int middle = (last-first)/2+first;
            int row = middle/n;
            int collumn = middle%n;
            
            if(matrix[row][collumn] == target)
            {
                return true;
            }
            else if(matrix[row][collumn]>target)
            {
                last = middle-1;
            }
            else
            {
                first=middle+1;
            }
                
        }
        
        return false;
        
    }
}