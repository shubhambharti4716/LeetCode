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
    public ListNode findMiddle(ListNode head) {
        
        ListNode hare = head;
        ListNode turtle = head;
        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode secondHead = reverse(mid.next);

        ListNode firstHead = head;
        while(secondHead != null) {
            if(firstHead.val != secondHead.val)
                return false;
            
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return true;
    }
}