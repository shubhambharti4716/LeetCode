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
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode middle = head;
        ListNode last = head;

        while (last != null && last.next != null) {
            middle = middle.next;
            last = last.next.next;
        }

        return middle;
    }
}