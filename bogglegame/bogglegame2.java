package bogglegame;

import java.util.ArrayList;

public class bogglegame {
	Trie dic;
	bogglegame(){
		dic=new Trie();
		init();
	}
	
	public ArrayList<String> getword(char[][] board){
		ArrayList<String> res=new ArrayList<String>();
		boolean[][] v=new boolean[board.length][board[0].length];
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				getword(res,board,dic,sb,v,i,j);
			}
		}
		return res;
	}
	private void getword(ArrayList<String>res, char[][] board, Trie dict,StringBuffer sb,boolean[][] v,int i, int j){
		v[i][j]=true;
		sb.append(board[i][j]);
		//sb=sb+board[i][j];
		int state=dict.search(sb.toString());
		if(state==2){
			res.add(new StringBuffer(sb).toString());
		}else if(state==0){
			v[i][j]=false;
			sb.delete(sb.length()-1,sb.length());
			return;
		}
		
		if(i-1>=0&&j-1>=0&&!v[i-1][j-1])
			getword(res,board,dict,sb,v,i-1,j-1);
		if(i-1>=0&&!v[i-1][j])
			getword(res,board,dict,sb,v,i-1,j);
		if(i-1>=0&&j+1<=board[0].length-1&&!v[i-1][j+1])
			getword(res,board,dict,sb,v,i-1,j+1);
		if(j-1>=0&&!v[i][j-1])
			getword(res,board,dict,sb,v,i,j-1);
		if(j+1<=board[0].length-1&&!v[i][j+1])
			getword(res,board,dict,sb,v,i,j+1);
		if(i+1<=board.length-1&&j-1>=0&&!v[i+1][j-1])
			getword(res,board,dict,sb,v,i+1,j-1);
		if(i+1<=board.length-1&&!v[i+1][j])
			getword(res,board,dict,sb,v,i+1,j);
		if(i+1<=board.length-1&&j+1<=board[0].length-1&&!v[i+1][j+1])
			getword(res,board,dict,sb,v,i+1,j+1);
		
		sb.delete(sb.length()-1,sb.length());
		v[i][j]=false;	
	}
	
	private void init(){
		dic.add("kong");
		dic.add("xie");
		dic.add("but");
		dic.add("as");
		dic.add("box");	
		dic.add("ksk");
		dic.add("ie");
		dic.add("i");
		dic.add("bme");
		dic.add("bmf");
	}
}
