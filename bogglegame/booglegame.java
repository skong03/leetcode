package bogglegame;

import java.util.ArrayList;

public class booglegame {
	Trie dict;
	booglegame(){
		dict=new Trie();
		init();
	}
	
	public ArrayList<String> getword(char[][] board){
		return getword(board,dict);
	}
	
	public ArrayList<String> getword(char[][] board, Trie dic){
		ArrayList<String> res=new ArrayList<String>();
		boolean[][] v=new boolean[board.length][board.length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				//boolean[][] v=new boolean[board.length][board.length];
				dfs(res,board,dic,i,j,v,"");
			}
		}
		return res;
	}
	
	public void dfs(ArrayList<String> res, char[][] board, Trie dic, int i, int j, boolean[][] v, String temp){
		v[i][j]=true;
		temp=temp+board[i][j];
		if(dic.isword(temp))
			res.add(temp);
		if(!dic.contains(temp)){
			v[i][j]=false;
			return;
		}
		
		
		if(i>1&&j>1&&!v[i-1][j-1])
			dfs(res,board,dic,i-1,j-1,v,temp);
		if(i>1&&!v[i-1][j])
			dfs(res,board,dic,i-1,j,v,temp);
		if(i>1&&j<board[0].length-1&&!v[i-1][j+1])
			dfs(res,board,dic,i-1,j+1,v,temp);
		if(j>1&&!v[i][j-1])
			dfs(res,board,dic,i,j-1,v,temp);
		if(j<board[0].length-1&&!v[i][j+1])
			dfs(res,board,dic,i,j+1,v,temp);
		if(i<board[0].length-1&&j>1&&!v[i+1][j-1])
			dfs(res,board,dic,i+1,j-1,v,temp);
		if(i<board[0].length-1&&!v[i+1][j])
			dfs(res,board,dic,i+1,j,v,temp);
		if(i+1<board.length&&j+1<board[0].length)
			dfs(res,board,dic,i+1,j+1,v,temp);
		
		v[i][j]=false;
	}
	
	public void init() {
		dict.insert("xie", 0);
		dict.insert("but", 2);
		dict.insert("as",3);
		dict.insert("box", 4);	
		dict.insert("ksk", 4);
		//System.out.println(dict.getindex("r"));		
		 
	}
	
}
