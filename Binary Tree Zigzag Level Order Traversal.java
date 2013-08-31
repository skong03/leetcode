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
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        
        ArrayList<TreeNode> odd=new ArrayList<TreeNode>();
        ArrayList<TreeNode> eve=new ArrayList<TreeNode>();
        ArrayList<Integer> oddN=new ArrayList<Integer>();
        ArrayList<Integer> eveN=new ArrayList<Integer>();
        
        if(root==null)
            return res;
            
        odd.add(root);
        oddN.add(root.val);
        
        
        while(!odd.isEmpty()||!eve.isEmpty())
        {
            if(!odd.isEmpty())
            {res.add(new ArrayList<Integer>(oddN));}
            while(!odd.isEmpty())
            {
                TreeNode temp=odd.remove(odd.size()-1);
                oddN.remove(oddN.size()-1);
                if(temp.right!=null)
                {
                    eve.add(temp.right);
                    eveN.add(temp.right.val);
                }
                if(temp.left!=null)
                    {
                        eve.add(temp.left);
                        eveN.add(temp.left.val);
                    }
                
            }
            
            if(!eve.isEmpty())
            {res.add(new ArrayList<Integer>(eveN));}
            while(!eve.isEmpty())
            {
                TreeNode temp=eve.remove(eve.size()-1);
                eveN.remove(eveN.size()-1);
                if(temp.left!=null)
                {
                    odd.add(temp.left);
                    oddN.add(temp.left.val);
                }
                if(temp.right!=null)
                {
                    odd.add(temp.right);
                    oddN.add(temp.right.val);
                }
                
            }
        }
        return res;
    }
}