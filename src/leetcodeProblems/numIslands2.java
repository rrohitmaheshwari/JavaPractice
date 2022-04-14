/*
305. Number of Islands II
https://leetcode.com/problems/number-of-islands-ii/
O(m×n+L) L is number of operations
O(m*n) - union find arrays
*/

class Solution {
    int DIRECTIONS[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) 
    {
        List<Integer> result = new ArrayList<>();
        
        if (positions == null || positions.length == 0) 
        {
            return result;
        }
        
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        int count = 0;
        
        for (int[] position : positions) 
        {
            
            int x = position[0];
            int y = position[1];
            int index = x * n + y;
            
            // duplicate position
            if (parent[index] != -1) 
            {
                result.add(count);
                continue;
            }
            count++;
            parent[index] = index;
            for (int i[]:DIRECTIONS) 
            {
                int r = x + i[0];
                int c = y + i[1];
                if (isValid(m, n, r, c, parent)) 
                {
                    int neighborIndex = r * n + c;
                    int neighborRoot = findRoot(parent, neighborIndex);
                    
                    if (neighborRoot != index) 
                    {
                        parent[neighborRoot] = index;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private boolean isValid(int m, int n, int r, int c, int[] parent) 
    {
        if (r < 0 || c < 0 || r >= m || c >= n || parent[r * n + c] == -1) 
        {
            return false;
        }
        return true;
    }
    
    private int findRoot(int[] parent, int index) 
    {
        while (index != parent[index]) 
        {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
