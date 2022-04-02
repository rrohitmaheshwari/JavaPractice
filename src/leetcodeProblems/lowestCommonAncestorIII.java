/*
1650. Lowest Common Ancestor of a Binary Tree III
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
O(N)
O(1)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pParent = p;
        Node qParent = q;
	    
        int pi=0,qi=0;
        
        while(pParent.parent!=null)
        {
            pi++;  
            pParent = pParent.parent;
        }
          
        while(qParent.parent!=null)
        {
            qi++;
            qParent = qParent.parent;
        }
          
        
         pParent = p;
         qParent = q;
        
        while(pi>qi)
        {
            pi--;
            pParent = pParent.parent;
        }
        
        while(qi>pi)
        {
            qi--;
            qParent = qParent.parent;
        }
        
        // both pParent & qParent are now in same level
        
        while(pParent!=qParent)
        {
             pi--;
            pParent = pParent.parent;
            qi--;
            qParent = qParent.parent;
        }
        
        return pParent;
    }
}