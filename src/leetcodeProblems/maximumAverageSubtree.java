/*
1120. Maximum Average Subtree
https://leetcode.com/problems/maximum-average-subtree/
O(N)
O(N)
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
    
    class State
    {
        int nodeCount;
        int valueSum;
        double maxAvg;
        
        State(int nodeCount, int valueSum, double maxAvg)
        {
            this.nodeCount=nodeCount;
            this.valueSum=valueSum;
            this.maxAvg=maxAvg;
        }
    }
    public double maximumAverageSubtree(TreeNode root) {
         return findMaxAvg(root).maxAvg;
    }
    
    State findMaxAvg(TreeNode node)
    {
        if(node == null)
        {
            return new State(0,0,0D);
        }
        
        
        State left= findMaxAvg(node.left);
        State right= findMaxAvg(node.right);
        
        //calculate nodeCount;
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        
        //calculate sum so that we can calc avg
        int sum = left.valueSum + right.valueSum + node.val;
        
        //calculate max avg
        double maxAverage = Math.max(
            (sum/(double)nodeCount)
        ,
        Math.max(left.maxAvg,right.maxAvg));
        
        return new State(nodeCount,sum,maxAverage);
        
        
    }
}