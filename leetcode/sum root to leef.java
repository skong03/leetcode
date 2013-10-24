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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        return recImp(0, root);
    }
    private int recImp(int sum, TreeNode root){
        int tmp = sum*10 + root.val;
        if(root.left!=null && root.right!=null) 
            return recImp(tmp, root.left) + recImp(tmp, root.right);
        else if(root.left!=null && root.right==null)
            return recImp(tmp, root.left);
        else if(root.left==null && root.right!=null)
            return recImp(tmp, root.right);
        else return tmp;
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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sumImp(root, 0, 0);
    }
    
    private int sumImp(TreeNode x, int sum, int tmp){
        if(x == null)
            return 0;
            
        tmp *= 10;
        
        if(x.left == null && x.right == null)
            return sum + tmp + x.val;
        
        
        if(x.left != null)
            sum = sumImp(x.left, sum, tmp + x.val);
        if(x.right != null)
            sum = sumImp(x.right, sum, tmp + x.val);
        return sum;
    }
}