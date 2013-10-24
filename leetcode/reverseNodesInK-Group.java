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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)    return head;
        
        ListNode p = new ListNode(Integer.MIN_VALUE);
        ListNode start = p;
        p.next = head;
        ListNode c = p.next;
        ListNode n = c.next;
        
        int cnt = 0;
        ListNode current = head;
        while(current != null){
            cnt++;
            current = current.next;
        }
        
        if(cnt < k)
            return head;
        
        int times = cnt/k;
        for(int i=0; i<times; i++){
            cnt = 1;
            while(cnt < k){
                c.next = n.next;
                n.next = p.next;
                p.next = n;
                n = c.next;
                cnt++;
            }
            if(n != null){
                p = c;
                c = n;
                n = n.next;
            }
        }
        
        return start.next;
    }
}





//This is a algorithm that reverse first k nodes in the linkedlist.
//Though not correct to this problem, can be a reference.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)    return null;
        
        ListNode p = new ListNode(Integer.MIN_VALUE);
        p.next = head;
        ListNode c = p.next;
        ListNode n = c.next;
        
        int cnt = 0;
        ListNode current = head;
        while(current != null){
            cnt++;
            current = current.next;
        }
        
        if(cnt < k)
            return head;
        
        cnt = 1;
        while(cnt < k){
            c.next = n.next;
            n.next = p.next;
            p.next = n;
            n = c.next;
            cnt++;
        }
        
        return p.next;
    }
}