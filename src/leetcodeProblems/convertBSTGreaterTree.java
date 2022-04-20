/*
538. Convert BST to Greater Tree
https://leetcode.com/problems/convert-bst-to-greater-tree/
O(N)
O(N) -> Mem Stack
// Most optimized sol is Reverse Morris In-order Traversal with uses O(1)
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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) 
    {
        
        dfsHelper(root);
        
        return root;
        
    }
    
    void dfsHelper(TreeNode root)
    {
        if(root == null)
            return;
        
        dfsHelper(root.right);
        
        // running sum
        sum = sum + root.val; 
        
        // update value with running sum
        root.val = sum;
        
        dfsHelper(root.left);
    
    }
}