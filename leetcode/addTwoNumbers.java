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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0, digit = 0;
        ListNode res = new ListNode(0);
        ListNode start = res;
        while(l1!=null && l2!=null){
            digit = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)>9?1:0;
            res.next = new ListNode(digit);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            digit = (l1.val+carry)%10;
            carry = (l1.val+carry)>9?1:0;
            res.next = new ListNode(digit);
            res = res.next;
            l1 = l1.next;
        }
        while(l2 != null){
            digit = (l2.val+carry)%10;
            carry = (l2.val+carry)>9?1:0;
            res.next = new ListNode(digit);
            res = res.next;
            l2 = l2.next;
        }
        if(carry == 1) res.next = new ListNode(1);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res = null;
        ListNode pre = null;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int bitSum = 0;
            int bit;
            if(l1 != null && l2 != null){
                bitSum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 != null){
                bitSum = l1.val + carry;
                l1 = l1.next;
            }
            else{
                bitSum = l2.val + carry;
                l2 = l2.next;
            }
            
            bit = bitSum % 10;
            carry = bitSum/10;
            ListNode x = new ListNode(bit);
            if(res == null){
                res = x;
                pre = res;
            }
            else{
                pre.next = x;
                pre = x;
            }
        }
        
        if(carry == 1){
            ListNode x = new ListNode(1);
            pre.next = x;
        }
        
        return res;
    }
}