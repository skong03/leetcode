//import java.util.ArrayList;


 // Definition for binary tree
  
 
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null)
        {return res;}
        ArrayList<TreeNode> odd= new ArrayList<TreeNode>();
        ArrayList<TreeNode> eve= new ArrayList<TreeNode>();
        ArrayList<Integer> temp1=new ArrayList<Integer>();
        ArrayList<Integer> temp2=new ArrayList<Integer>();
        
        odd.add(root);
        
        temp1.add(root.val);
        while(odd.size()!=0 || eve.size()!=0)
        {if(odd.size()!=0)
        {
            res.add(new ArrayList<Integer>(temp1));
            //System.out.println(res);
            while(odd.size()!=0)
            {
                //System.out.println(odd);
                TreeNode top = odd.remove(0);
                temp1.remove(0);
                if(top.left!=null)
                    {
                        eve.add(top.left);
                        temp2.add(top.left.val);
                    }
                if(top.right!=null)
                    {
                        eve.add(top.right);
                        temp2.add(top.right.val);
                    }
                //System.out.println(res);
            }
        }
        
        if(eve.size()!=0)
        {
            res.add(new ArrayList<Integer>(temp2));
            while(eve.size()!=0)
            {
                TreeNode top=eve.remove(0);
                temp2.remove(0);
                if(top.left!=null)
                {
                    odd.add(top.left);
                    temp1.add(top.left.val);
                }
                if(top.right!=null)
                {
                    odd.add(top.right);
                    temp1.add(top.right.val);
                }
            }
        }
        }
        //System.out.println(res);
        return res;
    }
}

