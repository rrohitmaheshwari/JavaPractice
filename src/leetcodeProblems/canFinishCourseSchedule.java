/*
207. Course Schedule
https://leetcode.com/problems/course-schedule/
O(N+E)
O(N)
*/
class Solution {
    
    class Node
    {
        List<Integer> children;
        int val;
        Node(int val)
        {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> NodesMap = new HashMap<>();
        
        for(int i[]:prerequisites)
        {
            if(!NodesMap.containsKey(i[0]))
            {
                NodesMap.put(i[0],new Node(i[0]));
            }
            if(!NodesMap.containsKey(i[1]))
            {
                NodesMap.put(i[1],new Node(i[1]));
            }
            NodesMap.get(i[0]).children.add(i[1]);
        }
        
        HashSet<Integer> seen;
        for(Map.Entry<Integer,Node> m:NodesMap.entrySet())
        {
            seen = new HashSet<>();

            if(!dfs(m.getValue(),seen,NodesMap))
                return false;
        }
        
        return true;
        
    }
    
    boolean dfs(Node n, HashSet<Integer> seen,HashMap<Integer,Node> NodesMap)
    {
        if(seen.contains(n.val))
           return false;
        
        if(n.children.isEmpty())
           return true;
 
        //for searching cycle
        seen.add(n.val);
        
        for(Integer ichild:n.children)
        {  
            Node nchild = NodesMap.get(ichild);
            if(dfs(nchild,seen,NodesMap) == false)
            {
                return false;
            }    
        }
        
        seen.remove(n.val);
        
        //emptying to reduce future search
        n.children = new ArrayList<>();
     
        return true;
    }
}