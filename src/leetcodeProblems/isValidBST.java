/*
98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/solution/
O(N)
O(N)
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
    public boolean isValidBST(TreeNode root) {
        
         return validate(root, null, null);
    }
    
       public boolean validate(TreeNode node, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (node == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return  validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}