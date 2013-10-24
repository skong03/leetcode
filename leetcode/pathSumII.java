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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> level = new ArrayList<Integer>();
        dfs(res, level, root, sum);
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> level, TreeNode root, int sum){
        if(root == null) return;
        level.add(root.val);
        if(root.left==null && root.right==null){
            if(sum == root.val) res.add(level);
            return;
        }
        ArrayList<Integer> level2 = (ArrayList<Integer>)level.clone();
        dfs(res, level, root.left, sum-root.val);
        dfs(res, level2, root.right, sum-root.val);
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> line = new ArrayList<Integer>();
        
        pathImp(root, sum, res, line);
        
        return res;
    }
    
    private void pathImp(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> line){
        if(root == null)
            return;
        
        line.add(root.val);
        
        if(root.left == null && root.right == null && root.val == sum){
            res.add(line);
            return;
        }
        
        ArrayList<Integer> lineLeft = (ArrayList<Integer>)line.clone();
        
        pathImp(root.left, sum-root.val, res, lineLeft);
        pathImp(root.right, sum-root.val, res, line);
    }
}