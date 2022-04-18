/*
323. Number of Connected Components in an Undirected Graph
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
O(N+E)
O(N+E)

BETER sol is union find as it uses less memory
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



/*
Union Find
O(N+E)
O(N)
*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int components = n;
        for (int[] e : edges) {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);
            if (p1 != p2) {
                if (size[p1] < size[p2]) { // Merge small size to large size
                    size[p2] += size[p1];
                    parent[p1] = p2;
                } else {
                    size[p1] += size[p2];
                    parent[p2] = p1;
                }
                components--;
            }
        }
        return components;
    }
    private int findParent(int[] parent, int i) {
        if (i == parent[i]) return i;
        return parent[i] = findParent(parent, parent[i]); // Path compression
    }
}