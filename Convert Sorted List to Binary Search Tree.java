public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        ArrayList<ListNode> al=new ArrayList<ListNode>();
        while(head!=null)
            {
                al.add(head);
                head=head.next;
            }
        return help(al,0,al.size()-1);
    }
    
    public TreeNode help(ArrayList<ListNode> al, int low, int high)
    {
        if(low>high)
            return null;
        if(low==high)
            {
                TreeNode root=new TreeNode(al.get(low).val);
                return root;
            }
            
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(al.get(mid).val);
        root.left=help(al,low,mid-1);
        root.right=help(al,mid+1,high);
        
        return root;
    }
}