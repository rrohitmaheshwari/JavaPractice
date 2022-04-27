/*
652. Find Duplicate Subtrees
https://leetcode.com/problems/find-duplicate-subtrees/
O(N) -> visiting every node
O(N) -> saving in map

Inorder Traversal
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
   List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return res;
    }
    
    String find(TreeNode root){
        if(root==null) return "#";
        
        int cur = root.val;
        String left = find(root.left);
        String right = find(root.right);
        
        String temp = "["+left+"]["+cur+"]["+right+"]";
        // System.out.println(temp);
        if(map.getOrDefault(temp, 0) == 1)
            res.add(root);
        map.put(temp, map.getOrDefault(temp, 0)+1);
		
        return temp;   
    }
}