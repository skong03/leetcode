public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ListNode res=new ListNode(0);
        res.next=head;
    
        
        ListNode start=res;
        ListNode end=res.next;
        ListNode temp=null;
        ListNode result=new ListNode(0);
        //result.next=temp;
        boolean f=true;
        
        while(end!=null)
        {
            while(end!=null&&end.val<x)
            {
                if(f)
                {temp=new ListNode(end.val);f=false;
                result.next=temp;
                }
                else 
                {
                    temp.next=new ListNode(end.val);
                    temp=temp.next;
                }
                end=end.next;
            }
            start.next=end;
            start=start.next;
            if(start!=null)
                end=start.next;
        }
        if(temp!=null)
            temp.next=res.next;
        else 
            result.next=res.next;
        
        return result.next;
        
    }
}
