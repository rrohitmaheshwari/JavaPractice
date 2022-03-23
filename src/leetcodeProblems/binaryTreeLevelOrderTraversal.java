/*
102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/
https://leetcode.com/explore/interview/card/linkedin/341/trees-and-graphs/1981/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root == null)
            return res;
        q.add(root);
        
        List<Integer> temp =new ArrayList<>();

        while(!q.isEmpty())
        {
            temp = new ArrayList<>();
            int len = q.size();
            while(len-->0)
            {
                TreeNode node = q.remove();
                 temp.add(node.val);
                if (node.left != null) 
                {
                    q.add(node.left);
                   
                }
                if (node.right != null) 
                {
                    q.add(node.right);
                    
                }
            }
             res.add(temp);
        }
        
        return res;
    }
}