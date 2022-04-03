/*
498. Diagonal Traverse
https://leetcode.com/problems/diagonal-traverse/
O(N)
O(1)
*/
class Solution {
     public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) 
            return new int[0];
         
        int r = 0
            , c = 0
            , m = matrix.length
            , n = matrix[0].length
            , arr[] = new int[m * n];
         
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0)  // moving up
            {
                if(c == n - 1)  // right wall 
                { 
                    r++; 
                }
                else if (r == 0) // up wall   
                { 
                    c++; 
                }
                else            
                { 
                    r--; 
                    c++; 
                }
            } 
            else // moving down
            {                
                if(r == m - 1)  // bottom wall
                { 
                    c++; 
                }
                else if (c == 0) // left wall
                { 
                    r++; 
                }
                else            
                { 
                    r++; 
                    c--; 
                }
            }   
        }   
        return arr;
    }
}