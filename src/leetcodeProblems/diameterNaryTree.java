/*
1522. Diameter of N-Ary Tree
https://leetcode.com/problems/diameter-of-n-ary-tree/
O(N)
O(N)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int diameter(Node root) {
        helper(root);
        return max;
    }
    
    int helper(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        
//         adding this will a bit optimization       
//         if (node.children.size() == 0)
//         {
//             return 1;  
//         }
        
       // select the top two largest heights
        int maxHeight1 = 0, maxHeight2 = 0;
        
        for (Node child : node.children) 
        {
            int curr = helper(child);
            
            if (curr > maxHeight1) 
            {
                maxHeight2 = maxHeight1;
                maxHeight1 = curr;
            } 
            else if (curr > maxHeight2) 
            {
                maxHeight2 = curr;
            }
            // calculate the diameter between the two farthest leaves nodes.
            // diameter disrecarding root count as its length - 1
            int diameter = maxHeight1 + maxHeight2;
            max = Math.max(max, diameter);
        }
        
        return maxHeight1+1;
        
    }
}