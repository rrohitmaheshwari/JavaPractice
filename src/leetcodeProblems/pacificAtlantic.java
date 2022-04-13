/*
417. Pacific Atlantic Water Flow
https://leetcode.com/problems/pacific-atlantic-water-flow/
O(N*M)
O(N*M)
*/

class Solution {
    
    // global constants for easy access
    private int numRows;
    private int numCols;
    private int[][] landHeights;
    
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        // Check if input is empty
        if (heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        
        // Save initial values to global parameters
        numRows = heights.length;
        numCols = heights[0].length;
        landHeights = heights;
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        // add edges
        for (int i = 0; i < numRows; i++) 
        {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, numCols - 1});
        }
        
        for (int j = 0; j < numCols; j++) 
        {
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{numRows - 1, j});
        }
        
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        boolean[][] pacificReachable = bfsTillPeak(pacificQueue);
        boolean[][] atlanticReachable = bfsTillPeak(atlanticQueue);
        
        // Intersection of True
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }
    
     private boolean[][] bfsTillPeak(Queue<int[]> queue)
    {
         boolean[][] reachable = new boolean[numRows][numCols];
          while (!queue.isEmpty()) 
          {
            int[] cell = queue.poll();
              
              // This cell is reachable, so mark it
              reachable[cell[0]][cell[1]] = true;
              
               for (int[] dir : DIRECTIONS)  // Check all 4 directions
               {
                   int newRow = cell[0] + dir[0];
                   int newCol = cell[1] + dir[1];
                   
                   if(!isValidCell(newRow,newCol)  // check if its not valid
                      || reachable[newRow][newCol]  // or already visited
                      || (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]])) // there is a drop so water wont flow opposite
                   {
                       continue;
                   }
                   
                   //we only need to consider increasing or equal points from current
                   queue.offer(new int[]{newRow, newCol});     
               }
          }
         return reachable; // boolean array
        
    }
    
    boolean isValidCell(int row,int col)
    {
         if (row < 0 || row >= numRows || col < 0 || col >= numCols) 
         {
             return false;
         }
        return true;
    }
}