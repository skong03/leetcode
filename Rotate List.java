public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        ListNode p2=head;
        ListNode p1=head;
        ListNode newhead=head;
        int count=0;
        
        if(n==0)
            return head;
            
        for(int i=0;i<n;i++)
        {
            p1=p1.next;
            count++;
            if(p1==null)
                break;
        }
        
        if(count==1&&p1==null)
            return head;
            
        if(p1==null)
        {
            p1=head;
            n=n%count;
            if(n==0)
                return head;
            for(int i=0;i<n;i++)
            {
                p1=p1.next;                
            }
            while(p1.next!=null)
            {
                p1=p1.next;
                p2=p2.next;
            }
            ListNode tail=p2;
            newhead=p2.next;
            while(tail.next!=null)
                tail=tail.next;
            tail.next=head;
            p2.next=null;
        }
        else
        {
            while(p1.next!=null)
            {
                p1=p1.next;
                p2=p2.next;
            }
            ListNode tail=p2;
            newhead=p2.next;
            while(tail.next!=null)
            {
                tail=tail.next;
            }
            tail.next=head;
            p2.next=null;
        }
        
        return newhead;
    }
}