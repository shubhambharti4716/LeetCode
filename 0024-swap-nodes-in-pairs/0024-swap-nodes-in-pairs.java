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
    public ListNode swapPairs(ListNode head) {
        //base case
        if(head == null || head.next == null)
            return head;  
        ListNode curr = head;
        // find nextHead
        ListNode nextHead = head;
        int count = 0;
        while(curr != null && count <2){
            curr = curr.next;
            nextHead = curr;
            count++;
        }
        // if we cannot make it up to count then our nextHead must be a           null value
        if(count < 2)
            nextHead = null;
        ListNode prev = head;
        ListNode next = head.next;
        next.next = prev;
        // call recursively for rest
        prev.next = swapPairs(nextHead);

        return next;
    }
}