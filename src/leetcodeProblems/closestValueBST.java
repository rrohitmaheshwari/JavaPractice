/*
270. Closest Binary Search Tree Value
https://leetcode.com/problems/closest-binary-search-tree-value/
O(H) - height of tree
O(1)
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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root!=null)
        {
           res = Math.abs(root.val - target)<Math.abs(res-target)?root.val:res;
            if(root.val<target)
            {
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
        
        return res;
        
    }
}