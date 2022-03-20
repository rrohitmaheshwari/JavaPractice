/*
951. Flip Equivalent Binary Trees
https://leetcode.com/problems/flip-equivalent-binary-trees/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3077/
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) // both null
        {
            return true;
        }
        // mismatch
       if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        
        //recursion with some nodes flip, some not.
        return 
            (flipEquiv(root1.left, root2.left) 
             && flipEquiv(root1.right, root2.right) 
             ||
                flipEquiv(root1.left, root2.right) 
             && flipEquiv(root1.right, root2.left));
    }
}