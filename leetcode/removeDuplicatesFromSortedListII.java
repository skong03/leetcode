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
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start, c = head;
        while(c!=null){
            if(c.next!=null && c.val==c.next.val){
                int tmp = c.val;
                while(c!=null && c.val==tmp) c = c.next;
                p.next = c;
                continue;
            }
            p = p.next;
            c = c.next;
        }
        return start.next;
    }
}



//练习
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
        if(head == null) return null;
        ListNode cur = head, start  =new ListNode(0), pre = start;
        start.next = head;
        while(cur != null){
            if(cur.next!=null && cur.val==cur.next.val){
                while(cur.next!=null && cur.val==cur.next.val) cur = cur.next;
                cur = cur.next;
                pre.next = cur;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return start.next;
    }
}





//目前最优解：
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
        if(head == null) return null;
        ListNode start = new ListNode(Integer.MIN_VALUE);
        ListNode p = start, c = head, n = head;
        start.next = head;
        while(c != null && c.next != null){
            while(n.next!=null && n.val == n.next.val) n = n.next;
            if(c == n){
                p.next = c;
                p = c;
            }
            c = n.next;
            n = n.next;
        }
        
        p.next = c;
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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        ListNode start = new ListNode(Integer.MIN_VALUE);
        start.next = head;
        ListNode p = start, c = head;
        while(c != null){
            if(c.next != null){
                if(c.val == c.next.val){
                    c = delete(c);
                    p.next = c;
                }
                else{
                    p = c;
                    c = c.next;
                }
            }
            else{
                p.next = c;
                c = c.next;
            }
        }
        
        return start.next;
    }
    private ListNode delete(ListNode x){
        while(x.next != null){
            if(x.val == x.next.val)
                x = x.next;
            else
                return x.next;
        }
        return null;
    }
}


//This method takes an extra of O(n) space.
//There must be a way need no extra space.
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
        ListNode current = head;
        ListNode start = new ListNode(0);
        ListNode mark = start;
        
        while(current != null){
            if(checkNext(current)){
                ListNode x = new ListNode(current.val);
                start.next = x;
                start = start.next;
            }
            else
                while(current.next != null && current.val == current.next.val)
                    current.next = current.next.next;
            
            current = current.next;
        }
        
        
        return mark.next;
    }
    
    private boolean checkNext(ListNode current){
        if(current.next == null)
            return true;
        else
            return current.val != current.next.val;
    }
}