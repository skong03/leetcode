public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height(root)!=-1)
            return true;
        else
            return false;
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
            
        int left=height(root.left);
        if(left==-1)
            return -1;
        int right=height(root.right);
        if(right==-1)
            return -1;
        
        int heightdiff=Math.abs(left-right);
        if(heightdiff>1)
            return -1;
        
        return Math.max(left,right)+1;
    }
}