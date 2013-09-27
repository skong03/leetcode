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


public class Solution {
    ArrayList<String[]> res;
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] board=new int[n];
        res=new ArrayList<String[]>();
        dfs(board,0);
        return res;
    }
    
    public void dfs(int[] board,int index){
        if(index==board.length)
        {record(board);return;}
        
        for(int i=0;i<board.length;i++)
        {
            board[index]=i;
            if(isvalid(board,index))
                dfs(board,index+1);
        }
    }
    
    public void record(int[] board){
        String[] s=new String[board.length];
        for(int i=0;i<board.length;i++)
        {
            s[i]="";
            for(int j=0;j<board.length;j++)
            {
                if(j==board[i])
                    s[i]=s[i]+"Q";
                else
                    s[i]=s[i]+".";
            }
        }
        res.add(s);
    }
    public boolean isvalid(int[] board,int index){
        for(int i=0;i<index;i++)
        {
            if(board[i]==board[index])
                return false;
            else if(index-i==Math.abs(board[index]-board[i]))
                return false;
        }
        return true;
    }
}