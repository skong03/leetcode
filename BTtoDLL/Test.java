package BTtoDLL;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n0=new TreeNode(1);
		TreeNode n00=new TreeNode(2);
		TreeNode n000=new TreeNode(3);
		TreeNode n001=new TreeNode(5);
		TreeNode n01=new TreeNode(7);
		TreeNode n011=new TreeNode(9);
		n0.left=n00;
		n0.right=n01;
		n00.left=n000;
		n00.right=n001;
		n01.right=n011;
		
		Solution m=new Solution();
		
		m.BTtoDLL(n0);
		TreeNode head=n000;
		
		while(head.right!=null){
			System.out.print("  "+head.val);
			head=head.right;
		}
	}

}
