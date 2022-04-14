/*
51. N-Queens
https://leetcode.com/problems/n-queens/
O(N!)
O(N*N)
*/

class Solution {
    int N;
    char grid[][];
    public List<List<String>> solveNQueens(int n) {
        N = n;
        grid = new char[n][n];
        
        
         for (int i = 0; i < n; i++) 
         {
            for (int j = 0; j < n; j++) 
            {
                grid[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        backtrack(0,new HashSet<>(),new HashSet<>(),new HashSet<>(),grid,res);
        
        return res;
    }
    
    void backtrack(int r,Set<Integer> diag, Set<Integer> negDiag, Set<Integer> cols,char grid[][],List<List<String>> res)
    {
         if (r == N) {
            res.add(createBoard(grid));
            return;
        }
        
         for (int col = 0; col < N; col++) 
         {
            int currDiagonal = r - col;
            int currAntiDiagonal = r + col;
             
            // If the queen is not placeable
            if (cols.contains(col) || diag.contains(currDiagonal) || negDiag.contains(currAntiDiagonal)) 
            {
                continue;    
            }
             
              // "Add" the queen to the board
            cols.add(col);
            diag.add(currDiagonal);
            negDiag.add(currAntiDiagonal);
            grid[r][col] = 'Q';

            // Move on to the next row with the updated board state
            backtrack(r + 1, diag, negDiag, cols, grid, res);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diag.remove(currDiagonal);
            negDiag.remove(currAntiDiagonal);
            grid[r][col] = '.';
         }
        
    }
    
     private List<String> createBoard(char[][] state) 
     {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < N; row++) 
        {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        
        return board;
    }
}