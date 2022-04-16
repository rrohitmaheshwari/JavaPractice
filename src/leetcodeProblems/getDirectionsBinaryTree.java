/*
2096. Step-By-Step Directions From a Binary Tree Node to Another
https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
O(N)
O(N) - to save path skewed tree
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
    public String getDirections(TreeNode root, int startValue, int destValue) 
    {
        // LCA WAY->
        // identify and get lca node
        // depth of startValue from lca
        // create path from lca to destValue
        // ans is depth*U + path to destValue
        // --------------------------------
        // BETTER WAY /or rather one more simpler way as we parse tree only twice with path func
        
        // create path for root-> startValue 
        StringBuilder st=new StringBuilder();
        path(root,startValue,st);
        st = st.reverse();
        System.out.println("st: "+st.toString());
        
        // create path for root-> destValue
        StringBuilder dt= new StringBuilder();
        path(root,destValue,dt);
        dt= dt.reverse();
        System.out.println("dt: "+dt.toString());
        
        // eliminate the common path
        StringBuilder res=new StringBuilder();
        int i=0,j=0;

        
        while(i<Math.min(st.length(),dt.length()) && st.charAt(i) == dt.charAt(i))
        {
            i++;
        }
        // reuse the remaning startValueString as UU & add it to remaning destValueString
        j=i;
        while(j!=st.length())
        {
            j++;
            res.append("U");
        }
        
        res.append(dt.substring(i,dt.length()));
       
        // System.out.println(dt.toString());
         System.out.println(i);
        return res.toString();
        
    }
    
     private boolean path(TreeNode root, int val, StringBuilder sb) {
         if(root == null) // it doesnt matter but good to have edge check
         {
             return false;
         }
          
        if (root.val == val) 
        {
            return true;
        }
         
        if (root.left != null && path(root.left, val, sb)) 
        { 
            sb.append("L");
            return true;
        }
         
        if (root.right != null && path(root.right, val, sb))  
        {
            sb.append("R");
            return true;
        }
         
        return false;
    }
}