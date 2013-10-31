public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null)
            return null;
        RandomListNode newhead=head;
        while(newhead!=null){
            RandomListNode after=new RandomListNode(newhead.label);
            after.next=newhead.next;
            newhead.next=after;
            newhead=newhead.next.next;
        }
        
        RandomListNode p=head;
        while(p.next.next!=null){
            if(p.random!=null)
                p.next.random=p.random.next;
            
            p=p.next.next;
        }
        
        if(p.random!=null)
            p.next.random=p.random.next;
        
        RandomListNode p3=head;
        RandomListNode result=p3.next;
        while(p3.next.next!=null){
            RandomListNode res=p3.next;
            p3.next=p3.next.next;
            res.next=p3.next.next;
            p3=p3.next;
        }
        p3.next=null;
        
        return result;
    }
}