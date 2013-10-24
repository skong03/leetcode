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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> s = new Stack<ArrayList<Integer>>();
        ArrayList<Integer> level;
        Que<TreeNode> q = new Que<TreeNode>();
        
        
        if(root == null)
            return res;
        
        level = new ArrayList<Integer>();
        q.enque(root);
        level.add(root.val);
        s.push(level);
        int cnt = 1;
        int exp = 0;
        
        level = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode x = q.deque();
            cnt--;
            
            if(x.left != null){
                q.enque(x.left);
                level.add(x.left.val);
                exp++;
            }
            
            if(x.right != null){
                q.enque(x.right);
                level.add(x.right.val);
                exp++;
            }
            
            if(cnt == 0){
                s.add(level);
                level = new ArrayList<Integer>();
                cnt = exp;
                exp = 0;
            }
        }
        
        s.pop();
        while(!s.empty())
            res.add(s.pop());
        
        return res;
    }
}


class Que<Item>{
    Node head;
	Node tail;
	
	public Que(){
		head = null;
		tail = null;
	}
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
			next = null;
		}
	}
	
	public void enque(Item item){
		Node x = new Node(item);
		if(isEmpty()){
			head = x;
			tail = x;
			return;
		}
		tail.next = x;
		tail = x;
	}
	
	public Item deque(){
		if(isEmpty())
			return null;
		Node tmp = head;
		head = head.next;
		return tmp.item;
	}
	
	public Item peek(){
		return head.item;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
}