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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p1 = l1, p2 = l2;
        ListNode start = new ListNode(0);
        ListNode current = start;
        while(p1 != null && p2 != null){
            if(p1.val<p2.val){
                current.next = p1;
                current = current.next;
                p1 = p1.next;
            }
            else{
                current.next = p2;
                current = current.next;
                p2 = p2.next;
            }
        }
        while(p1 != null){
            current.next = p1;
            current = current.next;
            p1 = p1.next;
        }
        while(p2 != null){
            current.next = p2;
            current = current.next;
            p2 = p2.next;
        }
        return start.next;
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode x = null;
        ListNode res = null;
        
        if(l1 != null && l2 != null){
            if(l1.val < l2.val){
                x = l1;
                l1 = l1.next;
            }
            else{
                x = l2;
                l2 = l2.next;
            }
        }
        res = x;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                x.next = l1;
                x = x.next;
                l1 = l1.next;
            }
            else{
                x.next = l2;
                x = x.next;
                l2 = l2.next;
            }
        }
        
        while(l1 != null){
            x.next = l1;
            x = x.next;
            l1 = l1.next;
        }
        while(l2 != null){
            x.next = l2;
            x = x.next;
            l2 = l2.next;
        }
        
        return res;
    }
}