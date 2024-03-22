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
    public boolean isPalindrome(ListNode head) {
        ListNode start = head;
        ListNode mid = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            mid = mid.next;
            fast= fast.next.next;
        }
        
        ListNode prev= null;
        ListNode next = null;
        
        while(mid != null){
            next = mid.next;
            mid.next = prev;
            prev= mid;
            mid = next;
        }
        
        while(prev!= null){

            if(prev.val!= start.val){
                return false;
            }
            prev= prev.next;
            start= start.next;
        }
        return true;
    }
}