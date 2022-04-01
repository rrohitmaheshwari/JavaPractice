/*
105. Construct Binary Tree from Preorder and Inorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
O(N)
O(N) - hashMap. .... recursion only will cause O(log N) stack so O(N + logN) = O(N)
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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> h = new HashMap<>(); //to store location 
        
        for(int i=0;i<inorder.length;i++)
        {
            h.put(inorder[i],i);
        }
        
        TreeNode root = helper(h,preorder,0,preorder.length-1);
        return root;
    }
    
    TreeNode helper(HashMap<Integer,Integer> h ,int[] preorder,int start,int end)
    {
        //end condition
        if(start>end)
        {
            return null;
        }
        int rootValue = preorder[index++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left=helper(h,preorder,start,h.get(rootValue)-1);
        root.right=helper(h,preorder,h.get(rootValue)+1,end);
        
        return root;
    }
}