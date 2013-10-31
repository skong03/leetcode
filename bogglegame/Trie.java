package bogglegame;

import java.util.ArrayList;

public class Trie {
	TreeNode root;
	Trie(){
		root=new TreeNode();
	}
	public void insert(String s, int num){
		insert(s,num,0,root);
	}
	public void insert(String s, int num, int pos, TreeNode r){
		if(pos==s.length()){
			r.isword=true;
			return;
		}
		char key=s.charAt(pos);
		r.indexes.add(num);
		if(r.children.containsKey(key)){
			insert(s,num,pos+1,r.children.get(key));
		}else{
			TreeNode n=new TreeNode();
			n.c=key;
			r.children.put(key, n);
			insert(s,num,pos+1,n);
		}
	}
	public boolean contains(String s){
		return contains(s,0,root);
	}
	public boolean contains(String s, int pos,TreeNode r){
		if(pos==s.length())
			return true;
		char key=s.charAt(pos);
		if(r.children.containsKey(key)){
			return contains(s,pos+1,r.children.get(key));
		}else
			return false;
	}
	
	public boolean isword(String s){
		return isword(s,0,root);
	}
	public boolean isword(String s, int pos,TreeNode r){
		if(pos==s.length()){
			if(r.isword)
				return true;
			else
				return false;
		}
		
		char key=s.charAt(pos);
		if(r.children.containsKey(key)){
			return isword(s,pos+1,r.children.get(key));
		}else
			return false;
	}
	
	public ArrayList<Integer> getindex(String s){
		return getindex(s,0,root);
	}
	public ArrayList<Integer> getindex(String s, int pos, TreeNode r){
		if(pos==s.length())
			return r.indexes;
		
		char key=s.charAt(pos);
		if(r.children.containsKey(key))
			return getindex(s,pos+1,r.children.get(key));
		else
			return null;
	}
}
