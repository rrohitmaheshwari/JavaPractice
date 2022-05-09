/*
61. Rotate List
https://leetcode.com/problems/rotate-list/
O(N)
O(1)

Copied from Leetcode
*/

class Solution {
  public ListNode rotateRight(ListNode head, int k) 
  {
    // base cases
    if (head == null) 
        return null;

    if (head.next == null) 
        return head;

    // close the linked list into the ring
      ListNode old_tail = head;
      ListNode new_tail = head;
      
    int n;
      
    for(n = 1; old_tail.next != null; n++)
    {
      old_tail = old_tail.next;  
    }
      
      old_tail.next = head; // making cycle

    // find new tail : (n - k % n - 1)th node
    // and new head : (n - k % n)th node
    
      
    for (int i = 0; i < n - (k % n) - 1; i++)
    {
        new_tail = new_tail.next;
    }
      
    ListNode new_head = new_tail.next;

    // break the ring
    new_tail.next = null;

    return new_head;
  }
}