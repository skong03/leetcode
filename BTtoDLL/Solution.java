package BTtoDLL;

public class Solution {
	public TreeNode BTtoDLL(TreeNode n) {
		if (n == null)
			return n;
		if (n.left != null) {
			TreeNode left = BTtoDLL(n.left);
			while (left.right != null)
				left = left.right;
			left.right = n;
			n.left=left;
		}

		if (n.right != null) {
			TreeNode right = BTtoDLL(n.right);
			while (right.left != null)
				right = right.left;
			right.left = n;
			n.right=right;
		}
		return n;
	}
}
