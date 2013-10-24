/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        ListNode cur = head;
        int cnt = 0;
        while(cur != null){
            cur = cur.next;
            cnt++;
        }
        int[] A = new int[cnt];
        int i = 0;
        cur = head;
        while(cur != null){
            A[i] = cur.val;
            cur = cur.next;
            i++;
        }
        return recImp(A);
    }
    private TreeNode recImp(int[] A){
        if(A==null || A.length==0) return null;
        int len = A.length, mid = (len-1)/2;
        TreeNode x = new TreeNode(A[mid]);
        x.left = recImp(Arrays.copyOfRange(A, 0, mid));
        x.right = recImp(Arrays.copyOfRange(A, mid+1, len));
        return x;
    }
}

































/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return null;
        
        int cnt = 0;
        ListNode current = head;
        while(current != null){
            cnt++;
            current = current.next;
        }
        
        int[] num = new int[cnt];
        current = head;
        cnt = 0;
        while(current != null){
            num[cnt++] = current.val;
            current = current.next;
        }
        
        return treeImp(0, cnt-1, num);
    }
    private TreeNode treeImp(int head, int tail, int[] num){
        if(head > tail)
            return null;
        if(head == tail)
            return new TreeNode(num[head]);
        
        int mid = (head + tail)/2;
        TreeNode x  = new TreeNode(num[mid]);
        x.left = treeImp(head, mid-1, num);
        x.right = treeImp(mid+1, tail, num);
        
        return x;
    }
}

















