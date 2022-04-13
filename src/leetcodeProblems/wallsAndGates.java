/*
286. Walls and Gates
https://leetcode.com/problems/walls-and-gates/
O(N*M)
O(N*M) - Queue can have all N*M
*/

class Solution {
    int DIRECTIONS[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        int M = rooms.length;
        if(M == 0)
            return;
        int N = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(rooms[i][j] == 0)
                {
                    q.add(new int[]{i,j}); // storing indexes
                }
            }
        }
        
        // perform bfs and update rooms
        while(!q.isEmpty())
        {
            int node[]=q.poll();
            
            for(int dir[]:DIRECTIONS)
            {
                int r=dir[0]+node[0];
                int c=dir[1]+node[1];
                
                if(!isValid(r,c,M,N) || rooms[r][c]!= 2147483647)
                {
                    continue;
                }
                
                rooms[r][c] = rooms[node[0]][node[1]] + 1;
                q.add(new int[]{r,c});
            }
        }
        
    }
    
    boolean isValid(int r,int c,int M,int N)
    {
        if(r<0 || c<0 || r>=M || c>=N)
            return false;
        
        return true;
    }
    
}