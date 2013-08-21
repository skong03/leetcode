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
        int car=0;
        ListNode current=new ListNode(-1);
        ListNode res=current;
        while(l1!=null||l2!=null)
        {
            int sum=car;
            if(l1!=null)
            {
                sum=l1.val+sum;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum=l2.val+sum;
                l2=l2.next;
            }
            
            car=sum/10;
            sum=sum%10;
            
            current.next=new ListNode(sum);
            current=current.next;
        }
        if(car==1)
            current.next=new ListNode(1);
        return res.next;
    }
}