/*
236. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
https://leetcode.com/explore/interview/card/linkedin/341/trees-and-graphs/1987/
O(N)
O(N)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.helper(root,p,q);
        return this.ans;
    }
    
    boolean helper(TreeNode n, TreeNode p, TreeNode q)
    {
        if(n==null) // leaf->next
        {
            return false;
        }
        
        int left = this.helper(n.left,p,q) ? 1:0;
        
        int right = this.helper(n.right,p,q) ? 1:0;
        
        int mid = (n == p || n == q) ? 1 : 0;
        
         // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = n;
        }

       // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
        
    }
}