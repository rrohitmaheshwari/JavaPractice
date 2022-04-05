/*
1382. Balance a Binary Search Tree
https://leetcode.com/problems/balance-a-binary-search-tree/
O(N)
O(N) - Array & call Stack
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
    public TreeNode balanceBST(TreeNode root) 
    {
        List<TreeNode> treeAsList = new ArrayList<>();
        
        //do inorder to fill the treeAsList
        inorder(treeAsList,root);
        
        //generate tree with keeping mid in root(~binary search logic)
        return generateBST(treeAsList, 0, treeAsList.size()-1);
        
    }
    
    void inorder(List<TreeNode> treeAsList, TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        inorder(treeAsList, node.left);
        treeAsList.add(node);
        inorder(treeAsList, node.right);
    }
    
    TreeNode generateBST(List<TreeNode> treeAsList, int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        TreeNode root;
        int middle = start+(end-start)/2;
        root = treeAsList.get(middle);
        root.left = generateBST(treeAsList, start, middle-1);
        root.right = generateBST(treeAsList, middle+1, end);
        return root;   
    }
    
}