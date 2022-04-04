/*
173. Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/
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
class BSTIterator {
    Queue<TreeNode> queue;
    
    public BSTIterator(TreeNode root) {
            this.queue = new LinkedList<TreeNode>();
                this._inorder(root);
    }
    
     private void _inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        this._inorder(root.left);
        this.queue.add(root);
        this._inorder(root.right);
    }
    
    public int next() {
        return  queue.poll().val;
        
    }
    
    public boolean hasNext() {
        
        return !queue.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */