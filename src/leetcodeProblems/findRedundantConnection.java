/*
684. Redundant Connection
https://leetcode.com/problems/redundant-connection/
O(N)  -> O(Nα(N))≈O(N)  union find uses Inverse-Ackermann funtion
O(N)
*/

class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        // Max nodes = 1000
        
        int parent[]=new int[1001];
        int rank[]=new int[1001];
        
        for(int i=0;i<1001;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        // call union on all edges
        for(int e[]:edges)
        {   
            if(!union(e[0],e[1],parent,rank))
            {
                return(new int[]{e[0],e[1]});
            }
        }
        
        return null;
    }
    
    int find(int index,int parent[])
    {
        if(parent[index]!=index)
        {
           parent[index] =  find(parent[index],parent);
        }
        
        return parent[index];
    }
    
    boolean union(int a,int b,int parent[],int rank[])
    {
        int aParent = find(a,parent);
        int bParent = find(b,parent);
        
       
        
        if(aParent == bParent) // cycle edge
        {
            return false;
        }
        else
        {
            if(rank[bParent]>rank[aParent])
            {
                parent[aParent] = bParent;
                rank[bParent]++;
            }
            else
            {
                parent[bParent] = aParent;
                rank[aParent]++;
            }
        }
        return true;
    }
    
}