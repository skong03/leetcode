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

//general result for I and II
public class Solution {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root==null)
            return;
        TreeLinkNode point=root;
        TreeLinkNode next=null;
        TreeLinkNode nextpoint=null;
        while(true){
            while(point!=null){
                if(point.left!=null){
                    if(next==null){
                        nextpoint=point.left;
                        next=point.left;
                    }else{
                        nextpoint.next=point.left;
                        nextpoint=nextpoint.next;
                    }
                }
                if(point.right!=null){
                    if(next==null){
                        nextpoint=point.right;
                        next=point.right;
                    }
                    else{
                        nextpoint.next=point.right;
                        nextpoint=nextpoint.next;
                    }
                }
                point=point.next;
            }
        
            if(next==null)
                break;
            else{
                point=next;
                next=null;
            }
        }
    }
}