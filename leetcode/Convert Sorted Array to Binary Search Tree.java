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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length < 1)
            return null;
        
        return treeImp(0, num.length-1, num);
    }
    
    private TreeNode treeImp(int head, int tail, int[] num){
        if(head > tail)
            return null;
        
        if(head == tail)
            return new TreeNode(num[head]);
            
        int mid = (head + tail)/2;
        TreeNode x = new TreeNode(num[mid]);
        x.left = treeImp(head, mid-1, num);
        x.right = treeImp(mid+1, tail, num);
        return x;
    }
}