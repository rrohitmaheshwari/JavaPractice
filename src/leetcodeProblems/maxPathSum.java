/*
124. Binary Tree Maximum Path Sum
https://leetcode.com/problems/binary-tree-maximum-path-sum/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3067/

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
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max_sum;
    }
    
    //recursive helper function 
    public int helper(TreeNode node)
    {
     
        if(node == null)
            return 0;
        // 0 represent not taking that path to gain value
        int l = Math.max(helper(node.left),0);
        int r = Math.max(helper(node.right),0);
            
        int  value = l+node.val+r;
        
        max_sum = Math.max(value,max_sum);
        
        return node.val + Math.max(l,r);
  
    }
}