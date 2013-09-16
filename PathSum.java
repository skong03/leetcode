public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return false;
        int sum1=sum-root.val;
        if(root.left==null&&root.right==null&&sum1==0)
            return true;
        else if(root.left!=null&&root.right!=null)
            return hasPathSum(root.left,sum1)||hasPathSum(root.right,sum1);
        else if(root.left!=null)
            return hasPathSum(root.left,sum1);
        else if(root.right!=null)
            return hasPathSum(root.right,sum1);
        else 
            return false;
        
    }
}