/*
100. Same Tree
https://leetcode.com/problems/same-tree/
O(N) - visting every node
O(LogH) - Stacks  ---> max is O(N) if tree is skewed
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        
        return helper(p,q);
    }
    boolean helper(TreeNode p, TreeNode q)
    {
         if(p == null && q == null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val != q.val)
            return false;
        return helper(p.left,q.left) && helper(p.right, q.right);
    }
    
}