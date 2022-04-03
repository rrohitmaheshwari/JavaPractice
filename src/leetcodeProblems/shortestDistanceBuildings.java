/*
317. Shortest Distance from All Buildings
https://leetcode.com/problems/shortest-distance-from-all-buildings/
O(N^2 *M^2)
O(NM) distance array
*/

class Solution {
    // down,up,right,left
    int dirs[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid) 
    {
        int minDistance = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalHouses = 0;

        int[][][] distances = new int[rows][cols][2];
        
         // Count houses and start bfs from each house.
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == 1) {
                             
                    totalHouses++;
                    bfs(grid, distances, row, col);
                    //  System.out.println("-----");
                    // for(int i=0;i<rows;i++)
                    // {
                    //     for(int j=0;j<cols;j++)
                    //     {
                    //         System.out.print(distances[i][j][0] + ","+distances[i][j][1]+ " "  );
                    //     }
                    //      System.out.println();
                    // }
                }
            }
        }
        
          for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (distances[row][col][1] == totalHouses) {
                    minDistance = Math.min(minDistance, distances[row][col][0]);
                }
            }
        }

        // If we haven't found a valid cell return -1.
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
        
    }
    
    void bfs(int[][] grid, int[][][] distances, int row, int col)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        
        //for bfs from 1
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col}); // adding 1
        
        
        // Keep track of visited cells.
        boolean[][] vis = new boolean[rows][cols];
        vis[row][col] = true;
        
           int steps = 0;
        
           while (!q.isEmpty()) 
           {
               for (int i = q.size(); i > 0; --i) 
               {
                   
           
                   int[] curr = q.poll();
                   row = curr[0];
                   col = curr[1];
                    
                   if (grid[row][col] == 0)  
                   {
                       distances[row][col][0] += steps;
                       distances[row][col][1] += 1;
                   }
                   
                   for (int[] dir : dirs) 
                   {
                       int nextRow = row + dir[0];
                       int nextCol = col + dir[1];
                       if (nextRow >= 0 
                           && nextCol >= 0 
                           && nextRow < rows 
                           && nextCol < cols) 
                       {
                            if (!vis[nextRow][nextCol] 
                                && grid[nextRow][nextCol] == 0) 
                            {
                                vis[nextRow][nextCol] = true;
                                q.offer(new int[]{ nextRow, nextCol });
                            }
                        }
                       
                   }    
               }
                           steps++;
           }
        
    }
}