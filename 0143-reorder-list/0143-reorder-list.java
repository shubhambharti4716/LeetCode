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
    public void reorderList(ListNode head) {
        
        ListNode cur = head;
        
        List<ListNode> list = new ArrayList<>();  
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }
        cur = head;  
        int l = 1, r = list.size() - 1;  
        int count = 0;
        while (l <= r){
            if (count % 2 == 0){
                
                cur.next = list.get(r);
                r--;
            }else {
                
                cur.next = list.get(l);
                l++;
            }
            
            cur = cur.next;
            count++;
        }
        
        cur.next = null;
    }
}