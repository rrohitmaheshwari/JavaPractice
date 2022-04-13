/*
130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/
O(N*M)
O(N*M) - dfs stack
*/

class Solution {
    int DIRECTIONS[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public void solve(char[][] board) {
        // observation is we cannot change the edges
        // so lets do reverse thinking by convering more 0s if joined by edge
        
        int R = board.length;
        int C = board[0].length;
        
        List<int[]> l= new LinkedList<>();
        
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if((i==0 || i== R-1 || j==0 || j== C-1)
                   && (board[i][j]=='O'))
                {
                    // perform dfs on q and convert O to T
                    dfs(R,C,board,i,j);
                }
            }
        }
        
        // convert remaining '0' to 'X' & then 'T' to '0'
         for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='T')
                {
                    board[i][j] = 'O';
                }
            }
        } 
    }
    
    void dfs(int R,int C,char[][] board,int r,int c)
    {
        if(r<0 || r>=R || c<0 || c>=C || board[r][c]!='O')
        {
            return;
        }
        board[r][c] = 'T';
        
        for(int d[]:DIRECTIONS)
        {
            dfs(R,C,board,r+d[0],c+d[1]);
        }         
    }
}