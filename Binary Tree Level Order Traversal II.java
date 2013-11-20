public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return res;
        ArrayList<TreeNode> queue=new ArrayList<TreeNode>();
        ArrayList<Integer> num=new ArrayList<Integer>();
        queue.add(root);
        num.add(root.val);
        res.add(0,num);
        int cur=1;
        int next=0;
        num=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode temp=queue.remove(0);
            cur--;
            if(temp.left!=null){
                queue.add(temp.left);
                num.add(temp.left.val);
                next++;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                num.add(temp.right.val);
                next++;
            }
            if(cur==0){
                cur=next;
                next=0;
                res.add(0,num);
                num=new ArrayList<Integer>();
            }
        }
        res.remove(0);//very important, remember that, and the differce between I and II is res add tail, another is add head
        return res;
    }
}