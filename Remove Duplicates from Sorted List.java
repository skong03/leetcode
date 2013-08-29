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
        
        ListNode start=head;
        ListNode end=head;
        while(end!=null)
        {
            while(end!=null && end.val==start.val)
            {
                end=end.next;
            }
            start.next=end;
            start=start.next;
        }
        return res.next;
        
    }
}