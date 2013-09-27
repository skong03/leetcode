public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res=new ListNode(0);
        res.next=head;
        
        ListNode preM=res;
        
        for(int i=1;i<m;i++)
            preM=preM.next;
        
        ListNode N=preM.next;
        for(int j=0;j<n-m;j++)
            N=N.next;
        
        while(preM.next!=N)
        {
            ListNode M=preM.next;
            preM.next=M.next;
            M.next=N.next;
            N.next=M;
        }
        
        return res.next;
    }
}