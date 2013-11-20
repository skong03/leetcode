public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n = root;
        ArrayList<Integer> res=new ArrayList<Integer>();
        while (!stack.isEmpty() || n!=null){
            if (n!=null){
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                res.add(n.val);
                n = n.right;
            }
        }
        return res;
    }
}


