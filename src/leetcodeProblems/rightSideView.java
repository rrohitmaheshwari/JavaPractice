/*
199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/
O(N)
O(D) - diameter
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
    public List<Integer> rightSideView(TreeNode root) {
        //bfs
        List<Integer> res = new ArrayList<>();
        
        if(root == null)
        {
            return res;
        }
        
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int len = q.size();
            for(int i=0;i<len;i++)
            {
                TreeNode node = q.poll();
                
                if(node.left != null)
                {
                    q.add(node.left);
                }
                if(node.right != null)
                {
                    q.add(node.right);
                }
                
                if(i==len -1)
                {
                    res.add(node.val);
                }
            }         
        }
        
        return res;
    }
}