/*
708. Insert into a Sorted Circular Linked List
https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
O(N)
O(1)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        
          if (head == null) 
          {
              Node newNode = new Node(insertVal, null);
              newNode.next = newNode;
              return newNode;
          }

		Node prev = head;
        Node curr = head.next;
        Node minNode = head;
        while (prev != head)
        {
            if(minNode.val>curr.val)
            {
                minNode = curr;
            }
            prev = curr;
            curr = curr.next;
        }
        
         prev = minNode;
         curr = minNode.next;
        boolean toInsert = false;
        
        do {
      if (prev.val <= insertVal && insertVal <= curr.val) {
        // Case 1).
        toInsert = true;
      } else if (prev.val > curr.val) {
        // Case 2).
        if (insertVal >= prev.val || insertVal <= curr.val)
          toInsert = true;
      }

      if (toInsert) {
        prev.next = new Node(insertVal, curr);
        return head;
      }

      prev = curr;
      curr = curr.next;
    } while (prev != minNode);
        
        // Case 3).
    prev.next = new Node(insertVal, curr);
    return head;
        
    }
}