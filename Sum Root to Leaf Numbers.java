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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        ArrayList<TreeNode> q=new ArrayList<TreeNode>();
        ArrayList<Integer> al=new ArrayList<Integer>();
        q.add(root);
        al.add(root.val);
        int sum=0;
           
        while(!q.isEmpty()){
            TreeNode n=q.remove(0);
            int num=al.remove(0);
            if(n.left==null&&n.right==null)
                sum=sum+num;
            if(n.left!=null)
            {
                q.add(n.left);
                al.add(num*10+n.left.val);
            }
            if(n.right!=null)
            {
                q.add(n.right);
                al.add(num*10+n.right.val);
            }
        }
        
        return sum;
    }
}