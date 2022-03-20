/*
329. Longest Increasing Path in a Matrix
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3072/

[[7,8,9],
 [9,7,6],
 [7,2,3]]

2,3,6,7,8,9

O(mn)
O(mn)
// DFS + Memoization Solution
*/
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int res=0;
        
        fillzero(visited,matrix.length,matrix[0].length);
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
             
                res = Math.max(res,searchlongest(i,j,visited,matrix,matrix.length-1,matrix[0].length-1));
            }
         }

            return res;
        
    }
    
    void fillzero(int[][] visited, int len1, int len2)
    {
        for(int i=0;i<len1;i++)
        {
            for(int j=0;j<len2;j++)
            {
               visited[i][j]=0; 
            }
        }
    }
    
    int searchlongest(int a,int b,int[][] visited,int[][] matrix, int len1, int len2)
    {
        if(visited[a][b]!=0)
        {
            return visited[a][b];
        }
        int up=0,down=0,left=0,right=0;
        
        if(isvalid(a+1,b,len1,len2) && matrix[a+1][b]>matrix[a][b])
        {
           up = searchlongest(a+1,b,visited,matrix,matrix.length-1,matrix[0].length-1);
        }
         if(isvalid(a,b+1,len1,len2) && matrix[a][b+1]>matrix[a][b])
        {
           right = searchlongest(a,b+1,visited,matrix,matrix.length-1,matrix[0].length-1);
        }
         if(isvalid(a-1,b,len1,len2) && matrix[a-1][b]>matrix[a][b])
        {
           down = searchlongest(a-1,b,visited,matrix,matrix.length-1,matrix[0].length-1);
        }
          if(isvalid(a,b-1,len1,len2) && matrix[a][b-1]>matrix[a][b])
        {
           left = searchlongest(a,b-1,visited,matrix,matrix.length-1,matrix[0].length-1);
        }
        visited[a][b] = Math.max(Math.max(up,down),Math.max(left,right))+1;
        return visited[a][b];
        
    }
    
    boolean isvalid(int a,int b, int len1, int len2)
    {
        if(a<0 || b<0 || a>len1 || b>len2)
        {
            return false;
        } 
        return true;
    }
}