/*
938. Range Sum of BST
https://leetcode.com/problems/range-sum-of-bst/
O(N) - every element
O(N) - stack
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
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return ans;
    }
    
    void helper(TreeNode root, int low, int high)
    {
        if(root == null)
        {
            return;
        }
        
        if(root.val<= high && root.val >= low)
        {
            ans+=root.val;
        }

        if(low < root.val)
        {
            helper(root.left,low,high);
        }
        if(high > root.val)
        {
             helper(root.right,low,high);
        }
    }
}