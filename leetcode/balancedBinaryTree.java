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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        int hl = findDepth(root.left);
        int hr = findDepth(root.right);
        if(Math.abs(hl-hr) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }
    private int findDepth(TreeNode cur){
        if(cur == null) return 0;
        return 1 + Math.max(findDepth(cur.left), findDepth(cur.right));
    }
}






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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return true;
        
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode x){
        if(x == null)
            return 0;
        return Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    }
}