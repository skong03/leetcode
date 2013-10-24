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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder==null || inorder.length==0) return null;
        int len = inorder.length;
        int val = postorder[len-1];
        TreeNode x = new TreeNode(val);
        int index = 0;
        for(int i=0; i<len; i++)
            if(inorder[i] == val){
                index = i;
                break;
            }
        x.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        x.right = buildTree(Arrays.copyOfRange(inorder, index+1, len), Arrays.copyOfRange(postorder, index, len-1));
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(postorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if(postorder.length == 1)
            return root;
            
        int i = 0;
        while(inorder[i] != postorder[postorder.length-1])
            i++;
        
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        
        root.right = buildTree(Arrays.copyOfRange(inorder, i+1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length-1));
        
        return root;
    }
}