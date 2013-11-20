public class Solution {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root==null)
            return;
        root.next=null;
        TreeLinkNode p=root;
        while(p!=null){
            TreeLinkNode next=null;
            TreeLinkNode p1=p;
            while(p1!=null){
                if(p1.left!=null){
                    if(next==null){
                        next=p1.left;
                        p=next;//p is head of next level
                    }else{
                        next.next=p1.left;
                        next=next.next;
                    }
                }
                
                if(p1.right!=null){
                    if(next==null){
                        next=p1.right;
                        p=next;
                    }
                    else{
                        next.next=p1.right;
                        next=next.next;
                    }
                }
                p1=p1.next;
            }
            if(next==null)
                break;
        }
    }
}