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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists==null || lists.size()==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){public int compare(ListNode a, ListNode b){return a.val>b.val?1:(a.val==b.val?0:-1);}});
        ListNode start = new ListNode(0);
        ListNode current = start;
        for(int i=0; i<lists.size(); i++)
            if(lists.get(i) != null) pq.add(lists.get(i));
        while(!pq.isEmpty()){
            current.next = pq.poll();
            current = current.next;
            if(current.next!=null) pq.add(current.next);
        }
        
        return start.next;
    }
}




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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){public int compare(ListNode a, ListNode b){return a.val>b.val?1:(a.val==b.val?0:-1);}});
        ListNode start = new ListNode(Integer.MIN_VALUE); 
        ListNode c = start;
        for(int i=0; i<lists.size(); i++)
            if(lists.get(i) != null)
                pq.add(lists.get(i));
        while(!pq.isEmpty()){
            ListNode x = pq.poll();
            c.next = x;
            c = c.next;
            if(x.next != null) pq.add(x.next);
        }
        return start.next;
    }
}









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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.size() == 0)
            return null;
        
        ListNode res = null;
        for(int i=0; i<lists.size(); i++){
            res = merge(res, lists.get(i));
        }
        
        return res;
    }
    
    private ListNode merge(ListNode a, ListNode b){
        ListNode x = null;
        ListNode res = null;
        
        if(a == null && b != null){
            x = b;
            return x;
        }
        else if(b == null && a != null){
            x = a;
            return x;
        }
        
        if(a != null && b != null){
            if(a.val < b.val){
                x = a;
                a = a.next;
            }
            else{
                x = b;
                b = b.next;
            }
        }
        
        res = x;
        
        while(a != null && b != null){
            if(a.val < b.val){
                x.next = a;
                a = a.next;
            }
            else{
                x.next = b;
                b = b.next;
            }
            x = x.next;
        }
        while(a != null){
            x.next = a;
            x = x.next;
            a = a.next;
        }
        while(b != null){
            x.next = b;
            x = x.next;
            b = b.next;
        }
        
        return res;
    }
}


















