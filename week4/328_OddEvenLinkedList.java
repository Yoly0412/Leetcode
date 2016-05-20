/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode end = head;
        ListNode cur = head.next.next;
        ListNode prev = head.next;
        ListNode temp = null;
        while(true) {
            temp = cur.next;
            prev.next = cur.next;
            cur.next = end.next;
            end.next = cur;
            if (temp == null || temp.next == null) {
                break;
            }
            end = cur;
            prev = temp;
            cur = prev.next;
        }
        return head;
    }
}