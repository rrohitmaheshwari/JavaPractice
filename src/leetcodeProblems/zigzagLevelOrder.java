/*
103. Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

O(N)
O(N)- can be improved if we go dfs way
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
      List<List<Integer>> res = new LinkedList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;
        
        while(!q.isEmpty()){
            int n = q.size();
            LinkedList<Integer> subList = new LinkedList<>();
            
            for(int i = 0; i < n; i++){
                TreeNode top = q.poll();
                
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                if(even)
                    subList.addLast(top.val);
                else
                    subList.addFirst(top.val);
            }
            res.add(subList);
            even = !even;
        }
        
        return res;
    }
}