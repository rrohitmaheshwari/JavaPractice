/*
543. Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3074/
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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return max;

    }
    
    int helper(TreeNode Node)
    {
      if(Node == null)
        {
            return 0;
        }
        int l=0,r=0;

        l = helper(Node.left);
        r = helper(Node.right);
        
        //diameter disrecarding root count as its length - 1
        max = Math.max(max,(l+r));
        
        // count side chain max length + 1 for current entry
        return 1+Math.max(l,r);
    }
}