/*
885. Spiral Matrix III
https://leetcode.com/problems/spiral-matrix-iii/solution/
O(Max(R,C)^2)
O(R*C)
*/
class Solution {
    int[][] DIRECTIONS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};  // right,down,left,up
    
    public int[][] c(int rows, int cols, int rStart, int cStart) 
    {
        int index=0;
        int len = rows*cols;
        
        int moveCount = 0;
        
        int d=0; //. direction indicator
        
        int res[][]=new int[len][2];
        
        // insert at start;
        res[index][0] = rStart;
        res[index][1] = cStart;
        index++;
        
        while(index<len)
        {
            if( d%2 == 0)
            {
                moveCount++;
            }
            
            for (int m = 0; m < moveCount; m++) {
                rStart += DIRECTIONS[d][0];
                cStart += DIRECTIONS[d][1];
                
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) // check valid
                {
                    res[index][0] = rStart;
                    res[index][1] = cStart;
                    index++;
                }
            }
            
            d = (d+1) %4;
            
        }
        
        return res;
        
    }
}