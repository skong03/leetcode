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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder==null || inorder.length==0) return null;
        int len = inorder.length, val = preorder[0], index = 0;
        TreeNode x = new TreeNode(val);
        while(inorder[index] != val) index++;
        x.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        x.right = buildTree(Arrays.copyOfRange(preorder, index+1, len), Arrays.copyOfRange(inorder, index+1, len));
        return x;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1)
            return root;
        
        int i = 0;
        while(inorder[i] != preorder[0])
            i++;
        
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
        
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
        
        return root;
    }
}