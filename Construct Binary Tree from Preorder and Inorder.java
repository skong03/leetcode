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


public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
       
    }
    public TreeNode build(int[] pre, int start1, int end1, int[] in, int start2, int end2){
        if(start1>end1||start2>end2)
            return null;
        
        TreeNode root=new TreeNode(pre[start1]);
        
        int i=start2;
        while(in[i]!=pre[start1]){
            i++;    
        }
        
        if(i>start2)
            root.left=build(pre,start1+1,start1+i-start2,in,start2,i-1);
        if(i<end2)
            root.right=build(pre,start1+i+1-start2,end1,in,i+1,end2);
        
        return root;
    }
}