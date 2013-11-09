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
        
        for(int i=1;i<k;i++)//each step move cur.next node to the front, do it k-1 times
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
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null)
            return null;
        ListNode tail=head;
        ListNode pre=new ListNode(0);
        pre.next=head;
        for(int i=1;i<k;i++){
            tail=tail.next;
            if(tail==null)
                return head;
        }
        
        ListNode cur=pre.next;
        ListNode n=cur.next;
        
        for(int i=1;i<k;i++){
            cur.next=n.next;
            n.next=pre.next;
            pre.next=n;
            n=cur.next;
        }
        
        cur.next=reverseKGroup(cur.next,k);
        return pre.next;
    }
}

//above two solution is same, the Node tail and num is useless for next step
//the solution move the cur.next to the front, do it k-1 times;
//the below solution is move first node after tail, do it k-1 times, when do recursion, need to know the last node
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null)
            return null;
        ListNode tail=head;
        ListNode pre=new ListNode(0);
        pre.next=head;
        for(int i=1;i<k;i++){
            tail=tail.next;
            if(tail==null)
                return head;
        }
        ListNode cur=pre.next;
        ListNode newNext=cur;//newNext is used to recursion, this is important, be aware of it
        for(int i=1;i<k;i++){//move cur to the end of tail, do it k-1 times
            pre.next=cur.next;
            cur.next=tail.next;
            tail.next=cur;
            cur=pre.next;
        }
        newNext.next=reverseKGroup(newNext.next,k);
        return pre.next;
    }
}