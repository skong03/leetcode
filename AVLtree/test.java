package AVLtree;

public class test {
	public static void main(String[] args){
		avltree<Integer> avl=new avltree<Integer>();
		avl.insert(19);
		avl.insert(11);
		avl.insert(3);
		avl.insert(2);
		avl.insert(1);
		avl.insert(16);
		avl.insert(20);
		avl.insert(4);
		avl.delete(19);
		avl.delete(16);
		//avl.delete(20);
		
	}
}
