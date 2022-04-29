/*
142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/
O(N)
O(1)

//  Floyd's Tortoise and Hare
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        do{
            try{
            slow = slow.next;
            fast = fast.next.next;
            }
            catch(Exception e)
            {
                return null; // no cycle
            }
            
        }while(slow!=fast);
        
            slow = head;
        
        // int index = 0;
        
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
            // index++;
        }
        
        return slow;
            
            
    }
}