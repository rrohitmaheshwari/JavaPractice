/*
230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    int ans;
    int K;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        helper(root,k);
        return ans;
    }
    
    void helper(TreeNode root, int k)
    {
        if(root == null)
            return;
        
        helper(root.left, K);
        
        K--;
        if(K==0)
        {
            ans = root.val;
            return;
        }
        
        helper(root.right, K);
        
    }
}