/*
572. Subtree of Another Tree
https://leetcode.com/problems/subtree-of-another-tree/
O(NM)
O(N)

We can further use KMP algorithm to optimize this.
https://leetcode.com/problems/subtree-of-another-tree/discuss/474425/JavaPython-2-solutions%3A-Naive-Serialize-in-Preorder-then-KMP-O(M%2BN)-Clean-and-Concise
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        
        // find the subRoot node in root tree
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNode n = q.poll();
            
            if(n.val == subRoot.val)
            {
                if(isEqual(n,subRoot))
                    return true;
            }
            if(n.left != null)
            {
                q.add(n.left);
            }
            
             if(n.right != null)
            {
                q.add(n.right);
            }
        }
        
        // node note found
        return false;    
    }
    
    boolean isEqual(TreeNode t1, TreeNode t2)
    {
        if(t1 == null && t2 == null)
            return true;
        
        if(t1==null || t2==null)
            return false;
        
        if(t1.val != t2.val)
            return false;
        
        return isEqual(t1.left,t2.left) && isEqual(t1.right,t2.right);
    }
}