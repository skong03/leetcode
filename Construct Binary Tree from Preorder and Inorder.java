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
        
        TreeNode root=new TreeNode(preorder[0]);
        if(preorder.length==1)
            return root;
            
        int i=0;
        while(inorder[i]!=preorder[0])
        {
            i++;
        }
        
        if(i>0)
        {
            root.left=buildTree(Arrays.copyRange(preorder,1,i+1), Arrays.copyRange(inorder,0,i));
        }
        if(i<preorder.length-1)
        {
            root.right=buildTree(Arrays.copyRange(preorder,i+1,preorder.length),Arrays.copyRange(inorder,i,inorder.length));
        }
        
        return root;
    }
}