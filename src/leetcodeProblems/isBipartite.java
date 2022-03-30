/*
785. Is Graph Bipartite?
DFS
O(V+E)
O(V)
*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodeCount = graph.length;
        
        int color[] = new int[nodeCount];
        Arrays.fill(color,-1); // no color initially
        
        for(int i=0;i<nodeCount;i++)
        {
            if(color[i]==-1) // not visited
            {
                //dfs
                Stack<Integer> stack = new Stack();
                stack.push(i);
                color[i]=0;
                
                while(!stack.isEmpty())
                {
                  Integer node = stack.pop();
                    
                    // check its adjacent
                    for (int adj: graph[node]) 
                    {
                        if (color[adj] == -1) 
                        {
                            stack.push(adj);
                            color[adj] = color[node] ^ 1; // reverse color of node
                        } 
                        else if (color[adj] == color[node]) 
                        {
                            return false; 
                        }
                    }
                }
            }
        }
        
        return true;
    }
}