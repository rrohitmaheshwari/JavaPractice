/*
778. Swim in Rising Water
https://leetcode.com/problems/swim-in-rising-water/
Time Complexity: O(N^2 * log N)    ->     O(logN) time to perform the heap operations.
Space: O(N^2)
*/

class Solution {
    
    int Directions[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        
        int N = grid.length;
        int M = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((lhs,rhs)->{
            return grid[lhs[0]][lhs[1]] - grid[rhs[0]][rhs[1]];
        });
        
        boolean visited[][]=new boolean[N][M];
        
        pq.add(new int[]{0,0});
        visited[0][0] = true;
        
        int res = 0;
        
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            
            int r = curr[0];
            int c = curr[1];
            int val = grid[r][c];
            
            res = Math.max(res,grid[r][c]);
            
            if(r == N-1 &&  c == M-1)
            {
                return res;
            }
            
            for(int d[]:Directions)
            {
                int rx = d[0] + r;
                int cx = d[1] + c;
                
                if(!isValid(rx,cx,N,M,visited)) //invalid
                {
                    continue;
                }
                
                //add to heap
                pq.add(new int[]{rx,cx});
                // add to visted so the no duplicates
                visited[rx][cx] = true;
            }      
        }
        
        return -1;   
    }
    
    boolean isValid(int rx,int cx,int N,int M,boolean visited[][])
    {
        if(rx<0 || cx<0 || rx>=N || cx>=M || visited[rx][cx])
        {
            return false;
        }
        
        return true;
    }
}