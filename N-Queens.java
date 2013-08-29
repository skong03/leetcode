public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res= new ArrayList<String[]>();
        int[] board=new int[n];
        dfs(res,board,n,0);
        return res;
    }
    
    public void dfs(ArrayList<String[]> res,int[] board, int n, int row)
    {
        if(row==n)
            {
                record(res,board,n);
                return;
            }
            
        for(int i=0;i<n;i++)
        {
            board[row]=i;
            if(isvalid(board,row))
            {
                dfs(res,board,n,row+1);
            }
        }
    }
    
    public boolean isvalid(int[] board, int row)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i]==board[row]||Math.abs(board[row]-board[i])==row-i)
                return false;
        }
        return true;
    }
    
    public void record(ArrayList<String[]> res, int[] board, int n){
        
        String[] temp=new String[n];
        for(int i=0;i<n;i++)
        {
            String str="";
            for(int j=0;j<n;j++)
            {
                if(j==board[i])
                    str+="Q";
                else
			str+=".";
            }
            temp[i]=str;
        }
        res.add(temp);
    }
}