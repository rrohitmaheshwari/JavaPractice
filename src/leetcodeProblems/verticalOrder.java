/*
314. Binary Tree Vertical Order Traversal
https://leetcode.com/problems/binary-tree-vertical-order-traversal/
O(NLogN)
O(N)

Better solution DFS
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 	* 
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

    int visitOrder=0;
    class NodeX
    {
        int val;
        int depth;
        int order; // representing level
        int visitOrder;
        NodeX(int val,int depth,int order,int visitOrder)
        {
            this.val = val;
            this.depth = depth;
            this.order = order;
            this.visitOrder = visitOrder;
        }
        
        @Override
    public String toString() {
        return this.val + "  - " + this.depth + "  - " + this.order;
    }
        
    }
    
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
        {
            return res;
        }
    
        PriorityQueue<NodeX> pq=new PriorityQueue<>((NodeX a, NodeX b)->{
            if(a.order>b.order)
            {
                return 1;
            }
            else if(a.order<b.order){
                return -1;
            }
            else
            {
                if(a.depth==b.depth)
                    return a.visitOrder-b.visitOrder;
                else
                    return a.depth - b.depth;
            }
            
        });
        
        NodeX temp = dfs(pq,root,0,0);
        
        // pq.add(temp);
        
        
        int cntr=-1;
        int prevOrder = -1;
        int cnt=-1;
        
        // System.out.println(Arrays.toString(pq.toArray()));
        
        while(!pq.isEmpty())
        {
             temp = pq.poll();

            if(cnt == -1 || prevOrder !=temp.order)
            {
                cnt++;
                prevOrder= temp.order;
            }
            
            if(res==null || res.size()<=cnt)
            {
                res.add(new ArrayList<Integer>());
            }

            res.get(cnt).add(temp.val);
            
        }
        return res;
        
    }
    
    NodeX dfs(PriorityQueue<NodeX> pq,TreeNode root,int depth,int order)
    {
        if(root == null)
        {
            return null;
        }
        
        //left
         NodeX left = dfs(pq,root.left,depth+1,order-1);
        
        //right
         NodeX right = dfs(pq,root.right,depth+1,order+1);
        
        

        NodeX res =  new NodeX(root.val,depth,order,visitOrder++);    
        pq.add(res);
        return res;
        
    }
}