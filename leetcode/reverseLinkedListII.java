//非递归的方法
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = new ListNode(Integer.MIN_VALUE);
        p.next = head;
        int index = 1;
        while(index < m){
            p = p.next;
            index++;
        }
        ListNode c = p.next;
        ListNode ne = c.next;
        ListNode mark = c;
        while(index < n){
            p.next = ne;
            ne = ne.next;
            p.next.next = c;
            c = p.next;
            index++;
        }
        mark.next = ne;
        if(p.val == Integer.MIN_VALUE) return p.next;
        else return head;
    }
}

//递归法：
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = 1;
        ListNode p = new ListNode(Integer.MIN_VALUE);
        p.next = head;
        while(index < m){
            index++;
            p = p.next;
        }
        
        ListNode mark = p.next;
        p.next = reverse(mark, p.next, index, n);
        if(p.val == Integer.MIN_VALUE) return p.next;
        else return head;
    }
    
    private ListNode reverse(ListNode mark, ListNode c, int start, int end){
        if(start == end){
            mark.next = c.next;
            return c;
        }
        else{
            ListNode n = c.next;
            c.next = null;
            ListNode x = reverse(mark, n, start+1, end);
            n.next = c;
            return x;
        }
    }
}