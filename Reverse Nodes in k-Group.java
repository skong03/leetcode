public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        ListNode res=new ListNode(0);
        res.next=head;
        ListNode c=head;
        ListNode n=c.next;
        
        ListNode num=head;

        for(int i=1;i<k;i++)//start from 1, easy to make mistake, check if the list long enough for k
        {
            num=num.next;
            if(num==null)
                return head;
        }
        
        for(int i=1;i<k;i++)//each step move n to the front, do it k-1 times
        {
            c.next=n.next;
            n.next=res.next;
            res.next=n;
            n=c.next;
        }
        
        c.next=reverseKGroup(n,k);
        
        return res.next;
   
    }
}