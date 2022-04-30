/*
112. Path Sum
https://leetcode.com/problems/path-sum/
O(N)
O(N) -> Skewed tree

DFS 
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return helper(root,0,targetSum);
    }

    
    boolean helper(TreeNode root, int sumTillNow, int targetSum)
    {
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null) //leaf
        {
            
            if(sumTillNow+root.val == targetSum)
            {
                return true;
            }         
            return false;
        }
        return helper(root.left,sumTillNow+root.val,targetSum) 
            || helper(root.right,sumTillNow+root.val,targetSum);
        
    }
}