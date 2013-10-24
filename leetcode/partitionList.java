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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode s = small, b = big, c = head;
        while(c != null){
            if(c.val < x){
                s.next = c;
                s = s.next;
                c = c.next;
                s.next = null;
            }
            else{
                b.next = c;
                b = b.next;
                c = c.next;
                b.next = null;
            }
        }
        s.next = big.next;
        return small.next;
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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        
        ListNode s = small;
        ListNode b = big;
        
        ListNode current = head;
        while(current != null){
            ListNode ln = new ListNode(current.val);
            if(current.val < x){
                small.next = ln;
                small = small.next;
            }
            else{
                big.next = ln;
                big = big.next;
            }
            current = current.next;
        }
        
        small.next = b.next;
        return s.next;
    }
}