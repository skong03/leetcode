package AVLtree;

public class TreeNode<V extends Comparable> {
	TreeNode<V> left,right,parent;
	V value;
	public TreeNode(V v){
		value=v;
	}
	public int hDiff(){
		return hDiff(this);
	}
	private int hDiff(TreeNode<V> n){
		return height(n.left)-height(n.right);
	}
	public int height(TreeNode<V> n){
		if(n==null)
			return -1;
		return Math.max(height(n.left), height(n.right))+1;
	}
}
