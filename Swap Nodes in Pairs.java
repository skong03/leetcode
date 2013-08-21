/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pre=new ListNode(0);
        ListNode res=pre;
        
        if(head!=null&& head.next==null)
            return head;
        while(head!=null&&head.next!=null){
            pre.next=head.next;
            head.next=head.next.next;
            pre.next.next=head;
        
            pre=head;
            head=head.next;
        }
        return res.next;
    }
}