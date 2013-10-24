/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        TreeLinkNode leftNode = root;
        while(leftNode != null){
            TreeLinkNode pre = leftNode, cur = pre.left;
            while(cur != null){
                if(cur == pre.left){
                    cur.next = pre.right;
                }
                else if(cur==pre.right && pre.next!=null){
                    cur.next = pre.next.left;
                    pre = pre.next;
                }
                
                cur = cur.next;
            }
            leftNode = leftNode.left;
        }
    }
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        TreeLinkNode l = root;
        while(l != null){
            TreeLinkNode tmp = l;
            while(tmp != null){
                if(tmp.left != null) tmp.left.next = tmp.right;
                if(tmp.right!=null && tmp.next!=null) tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            l = l.left;
        }
    }
}









/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode leftWall = root;
        while(leftWall != null){
            TreeLinkNode tmp = leftWall;
            while(tmp != null){
                if(tmp.left != null)
                    tmp.left.next = tmp.right;
                
                if(tmp.right != null && tmp.next != null)
                    tmp.right.next = tmp.next.left;
                
                tmp = tmp.next;
            }
            leftWall = leftWall.left;
        }
    }
}