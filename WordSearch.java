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
        if(word.charAt(index)!=board[i][j])
        {v[i][j]=false;return false;}
        
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
            
        v[i][j]=false;
        return false;
    }
}