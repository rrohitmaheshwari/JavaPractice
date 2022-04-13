/*
323. Number of Connected Components in an Undirected Graph
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
O(N+E)
O(N+E)
*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        
        List<Integer> adj[] = new ArrayList[n];
        boolean visited[] = new boolean[n];
        int components=0;
        
         for (int i = 0; i < n; i++) 
         {
            adj[i] = new ArrayList<Integer>();
         }
         
        for (int i = 0; i < edges.length; i++) 
        {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        for (int i = 0; i < n; i++) 
        {
            if (!visited[i]) 
            {
                components++;
                dfs(adj, visited, i);
            }
        }
        
        return components;
    }
    
     void dfs(List<Integer> adj[],boolean visited[], int index)
     {
         visited[index] = true;
         
         for(int i=0;i<adj[index].size();i++)
         {
             if(!visited[adj[index].get(i)])
             {
                 dfs(adj, visited, adj[index].get(i));  
             }
         }
     }
}