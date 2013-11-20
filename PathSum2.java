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
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        if(root==null)
            return res;
        dfs(res,temp,root,sum);
        return res;
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, TreeNode root, int sum)
    {
        int next=sum-root.val;
        temp.add(root.val);
        if(root.left==null&&root.right==null&&next==0)
            res.add(new ArrayList<Integer>(temp));
            
        if(root.left!=null)
            dfs(res,temp,root.left,next);
            
        if(root.right!=null)
            dfs(res,temp,root.right,next);
            
       temp.remove(temp.size()-1);
        return;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return res;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        temp.add(root.val);
        dfs(res, temp, root, sum-root.val);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, TreeNode root, int sum){
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if(root.left!=null){
            temp.add(root.left.val);
            dfs(res, temp, root.left,sum-root.left.val);
            temp.remove(temp.size()-1);
        }
        if(root.right!=null){
            temp.add(root.right.val);
            dfs(res,temp,root.right,sum-root.right.val);
            temp.remove(temp.size()-1);
        }
    }
}