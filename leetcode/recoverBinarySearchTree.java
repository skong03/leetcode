//技巧性很强的一道题，一个数组中有两个破坏顺序的元素，是哪两个？
//-->顺序遍历，第一个比后面值大的算一个；第二个就需要技巧了，侧面体现了此算法的给力
//-->第二个是最后一个前者大于后者pair的后者
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
    TreeNode pre, p, q;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pre = null;
        p = null;
        q = null;
        inorder(root);
        if(p!=null && q!=null){
            int tmp = q.val;
            q.val = p.val;
            p.val = tmp;
        }
    }
    private void inorder(TreeNode cur){
        if(cur != null){
            inorder(cur.left);
            if(pre!=null && pre.val>cur.val){
                if(p==null) p = pre;
                q = cur;
            }
            pre = cur;
            inorder(cur.right);
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
    ArrayList<TreeNode> al; 
    TreeNode pre;
    
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        al  = new ArrayList<TreeNode>();
        pre = null;
        
        inOrder(root);
        
        int tmp = al.get(0).val;
        al.get(0).val = al.get(al.size()-1).val;
        al.get(al.size()-1).val = tmp;
    }
    
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        
        if(pre != null && pre.val > root.val){
            if(!al.contains(pre))
                al.add(pre);
            if(!al.contains(root))
                al.add(root);
        }
        pre = root;
        
        inOrder(root.right);
    }
}