/*
426. Convert Binary Search Tree to Sorted Doubly Linked List
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
O(N)
O(N)
DFS way
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node leftMost = null;
    Node rightMost = null;
    public Node treeToDoublyList(Node root) {
        
        if (root == null) 
            return null;
        
        dfsHelper(root);
        
        leftMost.left = rightMost;
        rightMost.right  = leftMost;
        
        return leftMost;
        
    }
    
    void dfsHelper(Node root)
    {
        if(root == null)
            return;
        dfsHelper(root.left);
        
        if(leftMost == null)
        {
            leftMost = root;
        }
        else
        {
            // rightMost also represents last visited node
            rightMost.right = root;
            root.left = rightMost;
            
        }
        rightMost = root;
        dfsHelper(root.right);
    }
    
}