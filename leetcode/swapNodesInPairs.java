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
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start, c = head;
        while(c!=null && c.next!=null){
            p.next = c.next;
            c.next = c.next.next;
            p.next.next = c;
            p = c;
            c = p.next;
        }
        return start.next;
    }
}