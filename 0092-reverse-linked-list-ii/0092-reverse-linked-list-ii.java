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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = null, end = null, node = head;

        int i = 1;
        while (node != null) {
            if (i == left - 1) start = node;
            if (i == right + 1) end = node;
            node = node.next;
            i++;
        }

        ListNode ref = reverseList((start != null) ? start.next : head, start, end);
        if (start == null) return ref;
        return head;

    }

    public ListNode reverseList(ListNode head, ListNode start, ListNode end) {
        ListNode left = head;
        ListNode right = head.next;
        head.next = end;
        while (right != end) {
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        if (start != null)
            start.next = left;
        return left;
    }
}