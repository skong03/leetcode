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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        TreeNode l = root.left, r = root.right;
        root.left = null;
        root.right = null;
        if(l != null){
            flatten(l);
            root.right = l;
            while(root.right != null) root = root.right;
        }
        if(r != null){
            flatten(r);
            root.right = r;
            root = root.right;
            while(root.right != null) root = root.right;
        }
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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        recImp(root);
    }
    private TreeNode recImp(TreeNode root){
        if(root.left==null && root.right==null) return root;
        TreeNode l = root.left, r = root.right;
        root.left = null;
        root.right = null;
        if(l != null){
            root.right = l;
            root = recImp(l);
        }
        if(r != null){
            root.right = r;
            root = recImp(r);
        }
        return root;
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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function   
        if(root == null)
            return;
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        preOrder(root, tmp);
        
        root.left = null;
        TreeNode current = root;
        if(tmp.size() > 1){
            for(int i=1; i<tmp.size(); i++){
                TreeNode x = new TreeNode(tmp.get(i));
                current.right = x;
                current = current.right;
            }
        }
    }
    private void preOrder(TreeNode x, ArrayList<Integer> tmp){
        if(x != null){
            tmp.add(x.val);
            preOrder(x.left, tmp);
            preOrder(x.right, tmp);
        }
    }
}