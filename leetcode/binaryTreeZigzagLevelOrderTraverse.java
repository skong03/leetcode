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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return res;
        int size = 1, cnt = 0;
        boolean fromLeft = false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            cnt++;
            if(fromLeft) level.add(0, x.val);
            else level.add(x.val);
            if(x.left != null) q.add(x.left);
            if(x.right != null) q.add(x.right);
            if(cnt == size){
                size = q.size();
                cnt = 0;
                res.add(level);
                level = new ArrayList<Integer>();
                fromLeft = !fromLeft;
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)    return res;
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        boolean toLeft = true;
        
        q.add(root);
        int size = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            TreeNode x = q.removeFirst();
            
            if(toLeft)    level.add(x.val);
            else    level.add(0, x.val);
            
            if(x.left != null)  q.add(x.left);
            if(x.right != null) q.add(x.right);
            
            cnt++;
            
            if(cnt == size){
                res.add(level);
                level = new ArrayList<Integer>();
                size = q.size();
                cnt = 0;
                toLeft = !toLeft;
            }
        }
        
        return res;
    }
}