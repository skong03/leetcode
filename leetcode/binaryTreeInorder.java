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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        boolean flag = true;
        TreeNode cur = root;
        while(flag){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            else{
                if(st.isEmpty()) flag = false;
                else{
                    cur = st.pop();
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        inOrder(root, res);
        
        return res;
    }
    private void inOrder(TreeNode x, ArrayList<Integer> res){
        if(x != null){
            inOrder(x.left, res);
            res.add(x.val);
            inOrder(x.right, res);
        }
    }
}