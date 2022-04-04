/*
515. Find Largest Value in Each Tree Row
https://leetcode.com/problems/find-largest-value-in-each-tree-row/
O(N) - iterate over each element
O(N) - stack
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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res= new ArrayList<>();
        if(root == null)
        {
            return res;
        }
        
        int max;
        Queue<TreeNode> q =new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int len = q.size();
            max = q.peek().val;
            for(int i=0;i<len;i++)
            {
                TreeNode n = q.poll();
                max=Math.max(max,n.val);
                
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                     q.add(n.right);
                }
            }
            res.add(max);    
        }
        
        return res;
        
    }
}