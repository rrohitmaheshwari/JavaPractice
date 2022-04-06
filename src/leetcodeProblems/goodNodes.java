/*
1448. Count Good Nodes in Binary Tree
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
O(N)
O(N) - skewed tree stack 
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
    int cntr=0;
    public int goodNodes(TreeNode root) {
        helper(root,root.val);
            return cntr;
    }
    
    void helper(TreeNode root,int value)
    {
        if(root==null)
            return;
        
        helper(root.left,Math.max(root.val,value));
        if(root.val>=value)
        {
            cntr++;
        }
        helper(root.right,Math.max(root.val,value));
    }
}