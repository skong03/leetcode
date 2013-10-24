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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return true;
        
        ArrayList<Integer> leftA = new ArrayList<Integer>();
        ArrayList<Integer> rightA = new ArrayList<Integer>();
        
        inOrder(root.left, leftA);
        antiOrder(root.right, rightA);
        
        return checkImp(leftA, rightA);
    }
    
    private boolean checkImp(ArrayList<Integer> leftA, ArrayList<Integer> rightA){
        if(leftA.size() != rightA.size())
            return false;
        for(int i=0; i<leftA.size(); i++){
            if(leftA.get(i) != rightA.get(i))
                return false;
        }
        
        return true;
    }
    
    private void inOrder(TreeNode root, ArrayList<Integer> leftA){
        if(root != null){
            inOrder(root.left, leftA);
            leftA.add(root.val);
            inOrder(root.right, leftA);
        }
    }
    
    private void antiOrder(TreeNode root, ArrayList<Integer> rightA){
        if(root != null){
            antiOrder(root.right, rightA);
            rightA.add(root.val);
            antiOrder(root.left, rightA);
        }
    }
}