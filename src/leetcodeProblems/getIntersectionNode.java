/*
160. Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
O(N)
O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        int sizeA = GetSize(headA);
        int sizeB = GetSize(headB);

        for (int i = 0; i < Math.abs(sizeA - sizeB); i++)
        {
            if (sizeA > sizeB)
            {
                headA = headA.next;
            }
            else
            {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null)
        {
            if (headA == headB)
            {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int GetSize(ListNode head)
    {
        ListNode ptr = head;
        int count = 0;

        while (ptr != null)
        {
            count++;
            ptr = ptr.next;
        }

        return count;
    }
}