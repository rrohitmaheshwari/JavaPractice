/*
Here BFS is better answer as its space complexity would be log(N) if its a balanced tree and processor supports tail recursion; but worst case would still be O(N)
 */
class Solution 
{

/*
 // DFS space complexity would be O(N)
    int max= 0;
    public int maxDepth(TreeNode root) 
    {
        if(root == null)
        {
            return max;
        }

        helper(root,max+1);
        return max;
    }
    void helper(TreeNode node,int level)
    {
        max = Math.max(max,level);

        if(node.left!=null)
        {
            helper(node.left,level+1);
        }
        if(node.right!=null)
        {
            helper(node.right,level+1);
        } 
    }
*/

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

    Deque<TreeNode> dq = new ArrayDeque<>();
        int depth = 0, next = 0;
        TreeNode cur;
        dq.offer(root);
        
        while (!dq.isEmpty()) {
            depth++;
            next = dq.size();
            for (int i = 0; i < next; ++i) {
                cur = dq.poll();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
        }
        return depth;
    }
}