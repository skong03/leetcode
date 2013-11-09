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
//don't add null into heap
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(lists.isEmpty())
            return null;
        Comparator<ListNode> mycom= new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1,ListNode n2)
            {
                if(n1.val<n2.val)
                    return -1;
                if(n1.val==n2.val)
                    return 0;
                else
                    return 1;
            }
        };
        
        
        PriorityQueue<ListNode> heap= new PriorityQueue(lists.size(), mycom);
        
        for(ListNode n: lists)
        {
            if(n!=null)
                heap.add(n);
        }
        
        ListNode head=new ListNode(0);
        ListNode res=head;
        
        while(!heap.isEmpty())
        {
            ListNode temp=heap.poll();
            head.next=new ListNode(temp.val);
            if(temp.next!=null)
                heap.add(temp.next);
            head=head.next;
        }
        
        return res.next;
    }
}