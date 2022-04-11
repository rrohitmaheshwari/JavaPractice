/*
863. All Nodes Distance K in Binary Tree
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
O(N)
O(N)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        if(k==0)
            return Arrays.asList(target.val);
        
        HashMap<TreeNode,TreeNode> getParent = new HashMap();
        List<Integer> res= new ArrayList<>();
        //form parent structure
        dfs(root,target,null,getParent);
        
        //now lets perform modified bfs
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        
        q.add(target);
        q.add(null); // shows end of bfs level
        
        seen.add(target);
        seen.add(null);
        
        int dist = 1;
        
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)  // level break;
            {
                if(dist == k)
                {
                    while(!q.isEmpty())
                    {
                        TreeNode n = q.poll();
                        if(n == null)
                        {
                            break;
                        }
                      res.add(n.val);
                    }
                    return res;
                }
                q.add(null); // added at end of q to notify level end
                dist++;
            }
            else
            {
                if(node.left != null && !seen.contains(node.left))
                {
                    seen.add(node.left); // not to be added in q again
                    q.add(node.left);
                }
                
                 if(node.right != null && !seen.contains(node.right))
                {
                    seen.add(node.right); // not to be added in q again
                    q.add(node.right);
                }
                
                TreeNode par = getParent.get(node); 
                 if(par != null && !seen.contains(par))
                {
                    seen.add(par); // not to be added in q again
                    q.add(par);
                }
                
            }
            
        }
        
        return res;
        
        
        
        
    }
    
    void dfs(TreeNode root, TreeNode target,TreeNode parent,HashMap<TreeNode,TreeNode> getParent)
    {
        if(root == null)
            return;
        getParent.put(root,parent);
        dfs(root.left,target,root,getParent);
        dfs(root.right,target,root,getParent);
    }
}