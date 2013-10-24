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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = maxImp(root);
        
        return res[1];
    }
    private int[] maxImp(TreeNode x){
        int[] res = new int[2];
        
        if(x == null){
            res[0] = Integer.MIN_VALUE;
            res[1] = Integer.MIN_VALUE;
            return res;
        }
        
        int[] leftRes = maxImp(x.left);
        int[] rightRes = maxImp(x.right);
        
        int tmpLeft = leftRes[0]>0 ? leftRes[0]+x.val : x.val;
        int tmpRight = rightRes[0]>0 ? rightRes[0]+x.val : x.val;
        
        res[0] = Math.max(tmpLeft, tmpRight);
        res[1] = Math.max(leftRes[1], Math.max(rightRes[1], Math.max(tmpLeft+tmpRight-x.val, res[0])));
    
        return res;
    }
}