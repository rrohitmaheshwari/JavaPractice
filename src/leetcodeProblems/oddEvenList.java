/*
328. Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/
O(N)
O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
        {
            return head;
        }
        ListNode endNode = head;
        int length=0;
        
         while(endNode.next!=null)
        {
            length++;
            endNode= endNode.next;
        }
        
        if(length == 1)
        {
            return head;
        }
        
        ListNode even = head.next;
        ListNode odd = head;

        for(int i=0;i<length;i=i+2)
        {
            odd.next = even.next;
            odd = odd.next;
            
            endNode.next = even;
            even.next = null;
            endNode = endNode.next;
            
            even = odd.next;
        }
        return head;
        
    }
}