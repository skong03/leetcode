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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0;
        int right = 0;
        
        if(root == null)
            return 0;
        
        left = maxDepth(root.left) + 1;
        right = maxDepth(root.right) + 1;
        
        return Math.max(left, right);
    }
}