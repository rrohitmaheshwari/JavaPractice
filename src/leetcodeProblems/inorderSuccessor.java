/*
285. Inorder Successor in BST
https://leetcode.com/problems/inorder-successor-in-bst/
O(N) - skewed tree  O(log N) - balanced binary tree
O(1)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;
        
        while(root != null)
        {
            if(p.val>=root.val)
            {
                root=root.right;
            }
            else
            {
                successor = root; //probable
                root = root.left;
            }
        }
        
        return successor;
        
    }
}