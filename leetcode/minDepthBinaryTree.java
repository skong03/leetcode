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
        if(root == null)
            return 0;
        
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        
        if(root.left != null && root.right != null)
            return Math.min(left, right);
        else
            return Math.max(left, right);
    }
}