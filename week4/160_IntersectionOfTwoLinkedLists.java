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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode res = null;
        int sizeA = calSize(headA);
        int sizeB = calSize(headB);
        if (sizeA > sizeB) {
            headA = getNewHead(headA, sizeA - sizeB);
        } else {
            headB = getNewHead(headB, sizeB - sizeA);
        }
        while(headA != null) {
            if (headA == headB) {
                return headA;
            } 
            headA = headA.next;
            headB = headB.next;
        }
        return res;
    }
    private int calSize(ListNode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    private ListNode getNewHead(ListNode head, int step) {
        while(step != 0) {
            head = head.next;
            step--;
        }
        return head;
    }
}