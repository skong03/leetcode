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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        ArrayList<TreeNode> q=new ArrayList<TreeNode>();
        ArrayList<TreeNode> next=new ArrayList<TreeNode>();
        int count=0;
        
        q.add(root);
        
        while(!q.isEmpty()||!next.isEmpty())
        {
            count++;
            while(!q.isEmpty())
            {
                TreeNode temp=q.remove(0);
                if(temp.left!=null) next.add(temp.left);
                if(temp.right!=null) next.add(temp.right);
                if(temp.left==null&&temp.right==null)
                    return count;
            }
            count++;
            while(!next.isEmpty())
            {
                TreeNode temp=next.remove(0);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                if(temp.left==null&&temp.right==null)
                    return count;
            }
        }
        
        return count;
    }
}