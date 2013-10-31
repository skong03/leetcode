package AVLtree;

public class avltree<T extends Comparable> {
	private TreeNode<T> root;
	public void delete(T val){
		root=delete(root,val);
		inorder();
		System.out.println();
	}
	private TreeNode<T> delete(TreeNode<T> p, T val){
		if(p==null)
			return null;
		if(val.compareTo(p.value)>0){
			p.right=delete(p.right,val);
		}else if(val.compareTo(p.value)<0){
			p.left=delete(p.left,val);
		}else{
			if(p.left==null)
				p=p.right;
			else if(p.right==null)
				p=p.left;
			else{
				TreeNode<T> next=findnext(p.right);
				p.value=next.value;
				p.right=delete(p.right,next.value);
			}
		}
		if(p!=null)
			p=rotate(p);
		
		return p;
	}
	private TreeNode<T> findnext(TreeNode<T> n){
		while(n.left!=null)
			n=n.left;
		return n;
	}
	public void insert(T val){
		if(root==null)
			root=new TreeNode<T>(val);
		else
			root=insert(val,root);//after insertion, the root may change
		inorder();
		System.out.println();
	}
	private TreeNode<T> insert(T val, TreeNode<T> p){
		if(p==null)
			return new TreeNode<T>(val);
		
		if(val.compareTo(p.value)>0)//String,Integer implement the Comparable interface, so can be used directly, if you want to use self define class, need to impliment Comparable
			p.right=insert(val,p.right);
		else
			p.left=insert(val,p.left);
		p=rotate(p);//rotate from the bottom level.
		
		return p;
	}
	
	private TreeNode<T> rotate(TreeNode<T> p){
		if(p.hDiff()==2){
			if(p.left.hDiff()==1){//LL
				p=leftRotate(p,p.left);
			}else if(p.left.hDiff()==-1){//LR
				p.left=rightRotate(p.left,p.left.right);
				p=leftRotate(p,p.left);
			}
		}else if(p.hDiff()==-2){
			if(p.right.hDiff()==-1){//RR
				p=rightRotate(p,p.right);
			}else if(p.right.hDiff()==1){//RL
				p.right=leftRotate(p.right,p.right.left);
				p=rightRotate(p,p.right);
			}
		}
		return p;	
	}
	
	private TreeNode<T> leftRotate(TreeNode<T> p1, TreeNode<T> p2){
		TreeNode<T> p2Right=p2.right;
		p2.right=p1;
		p1.left=p2Right;
		return p2;
	}
	private TreeNode<T> rightRotate(TreeNode<T> p1, TreeNode<T> p2){
		TreeNode<T> p2left=p2.left;
		p1.right=p2left;
		p2.left=p1;
		return p2;
	}
	
	public void inorder(){
		inorder(root);
	}
	private void inorder(TreeNode<T> n){
		if(n==null)
			return;
		inorder(n.left);
		System.out.println("Node Id: "+n.value+"   heightDiffer:"+ n.hDiff());
		inorder(n.right);
	}
}
