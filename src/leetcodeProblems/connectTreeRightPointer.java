/*
116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
O(N) - every element
O(N) - Queue holding elements
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
        {
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size()>0)
        {
            int len = q.size();
            
            // iterate over level
            for(int i=0;i<len;i++)
            {
                  
                // Pop a node from the front of the queue
                Node node = q.poll();
                
                 if (i < len - 1) {
                    node.next = q.peek();
                }
                 // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                
            }
        }
                return root;
    }
}