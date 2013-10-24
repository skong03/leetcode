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
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        return validImp(root, min, max);
    }
    private boolean validImp(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val<=min || root.val>=max) return false;
        return validImp(root.left, min, root.val) && validImp(root.right, root.val, max);
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
    ArrayList<Integer> al;
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return true;
        
        al = new ArrayList<Integer>();
        
        inOrder(root);
        
        return checkImp(al);
    }
    
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        al.add(root.val);
        inOrder(root.right);
    }
    
    private boolean checkImp(ArrayList<Integer> al){
        
        for(int i=1; i<al.size(); i++)
            if(al.get(i-1) >= al.get(i))
                return false;
        
        return true;
    }
}