public class Solution {
    TreeNode pre,p,q;
    public void recoverTree(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
	pre=null;
	p=null;
	q=null;
        inorder(root);
        if(p!=null&&q!=null){
            int temp=p.val;
            p.val=q.val;
            q.val=temp;
        }
    }
    public void inorder(TreeNode n){
        if(n!=null){
        inorder(n.left);
        if(pre!=null && pre.val>n.val){
            if(p==null)
                p=pre;
            q=n;
        }
        pre=n;
        inorder(n.right);}
    }
}