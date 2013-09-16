public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        flatten1(root);
    }
    
    public TreeNode flatten1(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return root;
        
        TreeNode left,right,end;
        if(root.left!=null)
        {        
            left=root.left;
            right=root.right;
            root.right=left;
            root.left=null;
            end=flatten1(left);
            
            if(right!=null)
            {
                end.right=right;
                end=flatten1(right);
            }
        }
        else
        {
            end=flatten1(root.right);
        }
        return end;
    }
}