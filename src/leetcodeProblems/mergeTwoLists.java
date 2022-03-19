/*
21. Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
https://leetcode.com/explore/interview/card/google/60/linked-list-5/3065/

O(N+M)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1 == null) 
        //     return list2;
        // if(list2 == null)
        // {
        //     return list2;
        // }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                dummy.next= list1;     
                list1 = list1.next;
            }
            else
            {
                dummy.next= list2; 
                list2 = list2.next;
            }
             dummy=dummy.next;
        }
        
        dummy.next = list1 == null ? list2 : list1;
        
        return head.next;
        
    }
}