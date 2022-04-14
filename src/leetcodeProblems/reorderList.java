/*
143. Reorder List
https://leetcode.com/problems/reorder-list/
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
    public void reorderList(ListNode head) {
        
        ListNode firstList = head; 
        //find middle
        ListNode middle = findMiddle(head);
        
        //reverse 2nd half
        
        ListNode secondList = reverseList(middle);
        
        //merge sorted list
        mergeList(firstList, secondList);
        
    }
    
    ListNode findMiddle(ListNode n)
    {
        ListNode fp = n;
        ListNode sp = n;
        
        while(fp!=null && fp.next != null)
        {
            fp = fp.next.next;
            sp = sp.next;
        }
        
        return sp;
    }
    
    ListNode reverseList(ListNode n)
    {
        ListNode prev = null;
        ListNode curr = n;
        ListNode temp=null;
        while(curr!=null)
        {
            temp  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    void mergeList(ListNode first,ListNode second)
    {
        ListNode tmp = first;
        while(second.next != null)
        {
            tmp = first.next;
            first.next = second;
            first = first.next;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}