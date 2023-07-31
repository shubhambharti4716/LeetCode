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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)
        return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy,nex=dummy,prev=dummy;
    int count=0;
    while(cur.next!=null)
    {
        cur=cur.next;
        count++;

    }   
    while(count>=k)
    {
        cur=prev.next;
        nex=cur.next;
        for(int i=1;i<k;i++)
        {
              cur.next=nex.next;
              nex.next=prev.next;
              prev.next=nex;
              nex=cur.next;
        }
        prev=cur;
        count-=k;
    }    
    return dummy.next;
    }
}