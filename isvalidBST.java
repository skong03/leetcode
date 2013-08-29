

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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low=Integer.MIN_VALUE;
        int high=Integer.MAX_VALUE;
        
        return dfs(root,low,high);
    }
    
    public boolean dfs(TreeNode root, int low, int high)
    {
        if(root==null)
            return true;
        if(root.val<=low||root.val>=high)
            return false;
        else
            return dfs(root.left, low, root.val)&& dfs(root.right,root.val,high); 
    }
}