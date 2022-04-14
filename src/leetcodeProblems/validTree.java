/*
261. Graph Valid Tree
https://leetcode.com/problems/graph-valid-tree/
O(E+V)
O(V+E)
*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // aim:
        // 1. it should not have cycle
        // there should not be loose nodes
        //edge cases
        if(n == 0 || n == 1)
            return true;
        
        // create adjecency list
        ArrayList<Integer> adj[] = new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            adj[i] = new ArrayList<>();
        }
        
        for(int e[]:edges)
        {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        
        // 0  node will always exists
        return (dfs(0,-1,adj,visited) && (visited.size() == n));
    }
    
    boolean dfs(int curr,int prev,List<Integer> adj[],HashSet<Integer> visited)
    {
        
        List<Integer> neighbour = adj[curr];
        
        visited.add(curr);
               
        for(int neigh:neighbour)
        {
            if(neigh!=prev)
            {
                if(visited.contains(neigh) || !dfs(neigh,curr,adj,visited))
                {
                    return false;
                }
            }
        }    
        
         return true;
    }
}