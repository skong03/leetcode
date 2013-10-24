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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        if(len == n) return head.next;
        ListNode pre = head;
        for(int i=1; i<(len-n); i++) pre = pre.next;
        pre.next = pre.next.next;
        return head;
    }
}







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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cnt = 0;
        ListNode current = head;
        while(current != null){
            cnt++;
            current = current.next;
        }
        
        if(cnt == n)
            return head.next;
        
        current = head;
        for(int i=0;i<cnt-n-1;i++)
            current = current.next;
        current.next = current.next.next;
        
        return head;
    }
}