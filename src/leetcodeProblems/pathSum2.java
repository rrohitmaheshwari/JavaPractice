/*
113. Path Sum II
https://leetcode.com/problems/path-sum-ii/

O(N^2) -> DFS = O(N) but copying of element into new list would take O(N/2) -> O(N)  --> so time complexity really be would be O(N^2)

O(N) -> not including size of result  

DFS

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
     List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        // we need to find 1)sum till leaf node and 2)path till leaf node
        
        res = new ArrayList<>();
        
        helper(root,0,new ArrayList<>(),targetSum);
            
        return res; 
    }
    
    void helper(TreeNode root, int sumTillNow, List<Integer> path, int targetSum)
    {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) //leaf
        {
            
            if(sumTillNow+root.val == targetSum)
            {
                path.add(root.val);
                res.add(new ArrayList<>(path));  // takes O(N)
                path.remove(path.size()-1);
            }         
            return;
        }
        path.add(root.val);
        helper(root.left,sumTillNow+root.val,path,targetSum);
        helper(root.right,sumTillNow+root.val,path,targetSum);
        path.remove(path.size()-1);
        
    }
}