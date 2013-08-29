public class Solution {
    int count=0;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        count=0;//can't understand, if miss this, the answer is not correct
        int[] board=new int[n];
        dfs(n,0,board);
        return count;
    }
    
    public void dfs(int n, int row, int[] board)
    {
        if(row==n)
            {count++;return;}
        
        for(int i=0;i<n;i++)
        {
            board[row]=i;
            if(isvalid(board,row))
                dfs(n,row+1,board);
        }
    }
    
    public boolean isvalid(int[] board,int row)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i]==board[row]||Math.abs(board[row]-board[i])==row-i)
                return false;
        }
        return true;
    }
}