package validsoduku;

import java.util.ArrayList;

public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> pos=new ArrayList<Integer>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    pos.add(i*9+j);
                }
            }
        }
        //System.out.println(pos);
        dfs(board,pos,0);
        
        
        
    }
    public boolean dfs(char[][] board, ArrayList<Integer> pos,int i)
    {
        if(i==pos.size())
        	return true;
            
        
        int index=pos.get(i);
        int x=index/9;
        int y=index%9;
        
        for(int a=1; a<=9; a++)
        {      
            if(check(board,x,y,a))
            {
                board[x][y]=(char)('0'+a);
                if(dfs(board,pos,i+1))
                	return true;
                board[x][y]='.';
            }    
        }
        return false;
    }
    
    public boolean check(char[][] board, int x,int y, int ii)
    {
    	char temp=(char)(ii+'0');
        for(int i=0;i<9;i++)
        {
            if(board[x][i]==temp||board[i][y]==temp)
                return false;
            int a=3*(x/3)+i/3;
            int b=3*(y/3)+i%3;
            if(board[a][b]==temp)
                return false;
        }
        return true;
    }
}