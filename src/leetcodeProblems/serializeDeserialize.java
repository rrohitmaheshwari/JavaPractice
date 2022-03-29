/*
297. Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      return rserialize(root, "");
    }
    
     public String rserialize(TreeNode root, String str) {
    // Recursive serialization.
    if (root == null) {
      str += "null,";
    } else {
      str += str.valueOf(root.val) + ","; // ',' denote the end
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
    return rdeserialize(data_list);
    }
    
     public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
    if (l.get(0).equals("null")) {
      l.remove(0);  // remove from begin
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));