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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode a1 = list1;
        ListNode b1 = list1;
        ListNode c = list1;
        for(int i = 0; i <  b; i++){
            if(i == a - 1) b1 = a1;
            a1 = a1.next;
        }
        c = a1.next;
        b1.next = list2;
        while(list2.next != null) list2 = list2.next;
        list2.next = c;
        return list1;
    }
}