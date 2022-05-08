/*
156. Binary Tree Upside Down

O(N) -> Worst case
O(N) -> call stack

Note the any parent will have 2 child nodes
https://leetcode.com/problems/binary-tree-upside-down/

Ref: https://www.youtube.com/watch?v=JjaJQi77984
Time: 8:06 for figure
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
    TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        if(root == null)
            return null;
        
        return dfs(root);
    }
    
    public TreeNode dfs(TreeNode curr) {
        if(curr.left == null) 
            return curr;
        
        if(curr.left != null) 
            newRoot = dfs(curr.left);
        
        curr.left.left = curr.right;
        curr.left.right = curr;
        curr.left = null;
        curr.right = null;
        
        return newRoot;
    }
}