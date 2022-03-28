/*
94. Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res=new ArrayList<>();
        if(root == null)
            return res;
        inorder(root,res);
        return res;
    }
    
    void inorder(TreeNode node,List<Integer> res)
    {
        // inorder = left,parent,right
        
        if(node.left!=null)
             inorder(node.left,res);
        
        res.add(node.val);
        
         if(node.right!=null)
            inorder(node.right,res);
        
        
    }
}