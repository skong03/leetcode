package bogglegame;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeNode {
	char c;
	HashMap<Character, TreeNode> children;
	boolean isword;
	ArrayList<Integer> indexes;
	TreeNode(){
		children=new HashMap<Character,TreeNode>();
		isword=false;
		indexes=new ArrayList<Integer>();
	}
}
