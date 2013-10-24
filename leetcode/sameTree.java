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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        
        ArrayList<Integer> pi = new ArrayList<Integer>();
        ArrayList<Integer> qi = new ArrayList<Integer>();
        ArrayList<Integer> pp = new ArrayList<Integer>();
        ArrayList<Integer> qp = new ArrayList<Integer>();
        
        
        inOrder(p, pi);
        inOrder(q, qi);
        
        preOrder(p, pp);
        preOrder(q, qp);
        
        return checkImp(pi, qi) && checkImp(pp, qp);
    }
    
    private boolean checkImp(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a.size() != b.size())
            return false;
        
        for(int i=0; i<a.size(); i++)
            if(a.get(i) != b.get(i))
                return false;
        
        return true;
    }
    
    private void inOrder(TreeNode root, ArrayList<Integer> al){
        if(root != null){
            inOrder(root.left, al);
            al.add(root.val);
            inOrder(root.right, al);
        }
        else
            al.add(-1);
    }
    
    private void preOrder(TreeNode root, ArrayList<Integer> al){
        if(root != null){
            al.add(root.val);
            preOrder(root.left, al);
            preOrder(root.right, al);
        }
        else
            al.add(-1);
    }
}