
    public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] board=new int[m+1][n+1];
        for(int i=m-1;i>=0;i--)
        {
        	for(int j=n-1;j>=0;j--)
        	{
        		if(i==m-1&&j==n-1)
        		{
        			board[i][j]=1;
        		}
        		else
        			board[i][j]=board[i+1][j]+board[i][j+1];
        	}
        }
        return board[0][0];
        
    }
}



public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] board=new int[m][n];
        for(int i=m-1;i>=0;i--)
        {
        	for(int j=n-1;j>=0;j--)
        	{
        		if(i==m-1||j==n-1)
        		{
        			board[i][j]=1;
        		}
        		else
        			board[i][j]=board[i+1][j]+board[i][j+1];
        	}
        }
        return board[0][0];
        
    }
}
