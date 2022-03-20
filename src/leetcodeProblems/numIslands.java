/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3069/
*/
class Solution {
    int num_island = 0;
    public int numIslands(char[][] grid) {
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    islandFiller(i,j,grid,num_island+2);
                    num_island++;
                }
            }
        }
        
        return num_island;
        
    }
    
    private void islandFiller(int i,int j,char grid[][],int color)
    {
        if(i<0 || j<0 || i>=grid.length||j>=grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j]=(char)(color+'0');
        islandFiller(i+1,j,grid,color);
        islandFiller(i,j+1,grid,color);
        islandFiller(i-1,j,grid,color);
        islandFiller(i,j-1,grid,color);
        
    }
}
