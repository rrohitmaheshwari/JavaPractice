/*
671. Second Minimum Node In a Binary Tree
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
https://leetcode.com/explore/interview/card/linkedin/341/trees-and-graphs/1996/
*/

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        Queue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
      
        dfs(root, heap);
        
        if(heap.size()>1){
				return heap.peek();
        }
        return -1;
    }
    public void dfs(TreeNode root, Queue<Integer> heap){
        if(root == null) return;
        
        if(!heap.contains(Integer.valueOf(root.val))){ // can use set in this one
            heap.add(root.val);
            if(heap.size()>2){
                heap.poll();
            }
        }
        
        dfs(root.left, heap);
        dfs(root.right,heap);
        return;
    }
}

// better solution O(N)

class Solution {
    int min1;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}