/*
366. Find Leaves of Binary Tree
https://leetcode.com/problems/find-leaves-of-binary-tree/
O(N)
O(N) - skewed tree will cause N stack
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        // this is basically forming sets based on the height of the node
        List<List<Integer>> res= new ArrayList<>();
        dfs(res,root);
        return res;
    }
    
    int dfs(List<List<Integer>> res,TreeNode node)
    {
        if(node == null)
        {
            return -1;
        }
        
        int left =  dfs(res,node.left)+1;
        int right = dfs(res,node.right)+1;
        
        int height = Math.max(left,right);
        if(res.size() <= height)
        {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.val);
        return height;
    }
}