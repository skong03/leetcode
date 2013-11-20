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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res=new ListNode(0);
        res.next=head;
        
        ListNode start=res;
        ListNode end=start.next;
        int count=0;
        while(end!=null){
            count=0;
            while(end!=null && end.val==start.next.val)
            {
                count++;
                end=end.next;
            }
            
            if(count>1)
                start.next=end;
            else
                start=start.next;
        }
        return res.next;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode res=new ListNode(-1);
        res.next=head;
        ListNode slow=res;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            boolean f=false;
            while(fast!=null&&fast.next!=null&&fast.val==fast.next.val){
                fast=fast.next;
                f=true;
            }
            if(f){
                    slow.next=fast.next;
                    fast=slow.next;
                }
            else{
                    slow=slow.next;
                    fast=fast.next;
                }
        }
        return res.next;
    }
}