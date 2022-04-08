/*
133. Clone Graph
https://leetcode.com/problems/clone-graph/
O(N + M)
O(N)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null)
            return null;
        
        HashMap<Node, Node> visited = new HashMap();
        Queue<Node> q = new LinkedList<>();
        
        Node resHead= new Node(node.val, new ArrayList());
        q.add(node);
        visited.put(node,resHead);
        
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            
            for(Node neighbor: curr.neighbors)
            {
                if(!visited.containsKey(neighbor))
                {
                    visited.put(neighbor,new Node(neighbor.val, new ArrayList())); 
                    q.add(neighbor);
                }
                
                visited.get(curr).neighbors.add(visited.get(neighbor));      
            }
        }
        
        return resHead;
    }
}