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
        ListNode first=list1;
        ListNode second=list1;
        ListNode ans=first;
        int i=1;int j=0;
        while(i<a){
            first=first.next;
            i++;
        }
        while(j<b){
        second=second.next;j++;
        }
   first.next=list2;
    ListNode secon=list2;
while(secon.next!=null){
    secon=secon.next;
}
secon.next=second.next;


//System.out.println(first.next.val);
//System.out.println(second.val);

 return ans;   
    }
}