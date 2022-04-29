/*
298. Binary Tree Longest Consecutive Sequence
https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

O(N)
O(N)


DFS solution
*/

class Solution {
    int max=0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    
    int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        // Explore both the sides and keep adding to length
        int leftLen = dfs(root.left) + 1;
        int rightLen = dfs(root.right) + 1;
        
        // If the left of root is not in sequence, then update the left consecutive length as 1
        if(root.left != null && root.left.val != root.val + 1)
            leftLen = 1;
        
        // If the right of root is not in sequence, then update the right consecutive length as 1
        if(root.right != null && root.right.val != root.val + 1)
            rightLen = 1;
        
        // Max of left length and right length returns the current max
        int currMax = Math.max(leftLen, rightLen);
		
		// Update the global max and return the current max
        max = Math.max(max, currMax);
        return currMax;        
    }
}