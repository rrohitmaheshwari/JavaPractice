/*
1765. Map of Highest Peak
https://leetcode.com/problems/map-of-highest-peak/submissions/
O(R*C) - We are visiting every cell
O(R*C)  - we used queue to store value
BFS
*/

class Solution 
{
    int DIRECTIONS[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}}; // down,right,up,left
    
    public int[][] c(int[][] isWater) 
    {
        int R = isWater.length;
        int C = isWater[0].length;
        int height[][] = new int[R][C];
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(isWater[i][j]==1) // water
                {
                    height[i][j] = 0;
                    q.add(new int[]{i,j,0}); // row,col,height;
                }
                else
                {
                    height[i][j] = -1; // land needs to be evaluated later
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int cur[]=q.poll();
            int curHeight = cur[2];
            
            for(int i=0;i<4;i++)
            {
                int r=cur[0] + DIRECTIONS[i][0];
                int c=cur[1] + DIRECTIONS[i][1];
                
                if(isValidIndex(r,c,R,C) && height[r][c] == -1)
                {
                    height[r][c] = curHeight + 1;
                    q.add(new int[]{r,c,height[r][c]});
                }
            } 
        }
        
        return height;
    }
    
    boolean isValidIndex(int r,int c,int R,int C)
    {
        if(r<0 || c<0 || r>=R || c>=C)
            return false;
        return true;
    }
    
}