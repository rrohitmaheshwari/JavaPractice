/*
129. Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/
O(N)
O(N) - call stack
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
    int sum;
    public int sumNumbers(TreeNode root) {
        
        sum=0;
        
        //dfs
        helper(root,root.val);
        
        return sum;
    }
    
    void helper(TreeNode node,int number)
    {
        if(node.left==null && node.right==null)
        {
            sum+=number;
            return;
        }

        if(node.left!=null)
        {
            helper(node.left,number*10+node.left.val);
        }
        if(node.right!=null)
        {
            
        helper(node.right,number*10+node.right.val);
        }
        
    }
}