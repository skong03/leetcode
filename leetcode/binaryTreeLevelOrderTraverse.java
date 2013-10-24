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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return res;
        q.add(root);
        int size = 1, cnt = 0;
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            level.add(x.val);
            cnt++;
            if(x.left != null) q.add(x.left);
            if(x.right != null) q.add(x.right);
            if(cnt == size){
                size = q.size();
                cnt = 0;
                res.add(level);
                level = new ArrayList<Integer>();
            }
        }
        return res;
    }
}


//更加适用并且实用的BFS算法！
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        if(root == null) return res;
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int cnt = 0;
        int sum = 1;
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            tmp.add(x.val);
            cnt++;
            if(x.left != null) q.add(x.left);
            if(x.right != null) q.add(x.right);
            if(cnt == sum){
                res.add(tmp);
                tmp = new ArrayList<Integer>();
                sum = q.size();
                cnt = 0;
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
public class Solution{
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level;
        Que<TreeNode> q = new Que<TreeNode>();
        
        if(root == null)
            return res;
        
        level = new ArrayList<Integer>();
        q.enque(root);
        level.add(root.val);
        res.add(level);
        int exp = 0;
        int cnt = 1;
        
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
                res.add(level);
                level = new ArrayList<Integer>();
                cnt = exp;
                exp = 0;
            }
        }
        
        res.remove(res.size()-1);
        
        return res;
    }
}

class Que<Item>{
    Node head;
	Node tail;
	
    Que(){
		head = null;
		tail = null;
	}
	
	private class Node{
		Item item;
		Node next;
		
		Node(Item item){
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

