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
        if(num.length==0)
            return null;
        return help(num,0,num.length-1);
    }
    
    public TreeNode help(int[] num, int low, int high)
    {
        TreeNode root;
        if(high==low)
            {root=new TreeNode(num[low]);
            return root;}
        if(low>high)
            return null;
        int mid=(low+high)/2;
        
        root=new TreeNode(num[mid]);
        root.left=help(num,low,mid-1);
        root.right=help(num,mid+1,high);
        return root;
    }
}