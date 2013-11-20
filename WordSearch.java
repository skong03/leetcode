public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] v=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board,i,j,word,0,v))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int i, int j ,String word, int index, boolean[][] v)
    {
        v[i][j]=true;
        if(word.charAt(index)==board[i][j]){
            if(index==word.length()-1)
                return true;
            if(i>0&&!v[i-1][j]&&dfs(board,i-1,j,word,index+1,v))
                return true;
            if(i<board.length-1&&!v[i+1][j]&&dfs(board,i+1,j,word,index+1,v))
                return true;
            if(j>0&&!v[i][j-1]&&dfs(board,i,j-1,word,index+1,v))
                return true;
            if(j<board[0].length-1&&!v[i][j+1]&&dfs(board,i,j+1,word,index+1,v))
                return true;   
        } 
        v[i][j]=false;
        return false;
    }
}



public class Solution {
	public boolean exist(char[][] board, String word) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean[][] v=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,v,i,j))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, boolean[][] v, int x, int y){
        if(i==word.length()-1&&word.charAt(i)==board[x][y])//make mistake here
            return true;
        v[x][y]=true;
        if(word.charAt(i)==board[x][y]&&x-1>=0&&!v[x-1][y]&&dfs(board,word,i+1,v,x-1,y))
            return true;
        if(word.charAt(i)==board[x][y]&&y-1>=0&&!v[x][y-1]&&dfs(board,word,i+1,v,x,y-1))
            return true;
        if(word.charAt(i)==board[x][y]&&x+1<=board.length-1&&!v[x+1][y]&&dfs(board,word,i+1,v,x+1,y))
            return true;
        if(word.charAt(i)==board[x][y]&&y+1<=board[0].length-1&&!v[x][y+1]&&dfs(board,word,i+1,v,x,y+1))
            return true;
            
        v[x][y]=false;
        return false;
    }
}