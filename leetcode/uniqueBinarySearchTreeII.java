/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return treeImp(1, n);
    }
    private ArrayList<TreeNode> treeImp(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++)
            for(TreeNode left : treeImp(start, i-1))
                for(TreeNode right : treeImp(i+1, end)){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
        return res;
    }
}


//Á·Ï°
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        return recImp(1, n);
    }
    private ArrayList<TreeNode> recImp(int head, int tail){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(head > tail){
            res.add(null);
            return res;
        }
        for(int i=head; i<=tail; i++){
            for(TreeNode left : recImp(head, i-1)){
                for(TreeNode right : recImp(i+1, tail)){
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}