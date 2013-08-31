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
        //TreeLinkNode nextl=root;
        
        while(root!=null)
        {
            TreeLinkNode ac=root;
            while(ac!=null)
            {
                if(ac.left!=null)
                {
                    ac.left.next=ac.right;
                }
                if(ac.right!=null&&ac.next!=null)
                {
                    ac.right.next=ac.next.left;
                }
                ac=ac.next;
            }
            root=root.left;
        }
        
    }
}