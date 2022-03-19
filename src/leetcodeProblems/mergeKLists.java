/*
23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/342/

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
    public ListNode mergeKLists(ListNode[] lists) {
     
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1,l2)->( l1.val-l2.val));
        
        ListNode n = null;
        ListNode resultList = null;
        ListNode head = null;
        
        for(ListNode l:lists)
        {
            if(l!=null)
            pq.add(l);
        }

        while(!pq.isEmpty())
        {
            n = pq.poll();
            if(n.next != null)
            {
                pq.add(n.next);
            }
            
            if(resultList == null)
            {
                resultList = n;
                //set head to resultList
                head = resultList;
            }
            else
            {
                //Add element to list
                resultList.next = n;
                
                // Move the resultList
                resultList= resultList.next;
            }
        }
        
        // return head
        return head;
        
    }
}