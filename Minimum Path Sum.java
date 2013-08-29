public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=grid.length;
        int n=grid[0].length;
        int[][] board=new int[m][n];
        
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1&&j==n-1)
                    board[i][j]=grid[i][j];
                else if(i==m-1)
                    board[i][j]=board[i][j+1]+grid[i][j];
                else if(j==n-1)
                    board[i][j]=board[i+1][j]+grid[i][j];
                else
                    board[i][j]=grid[i][j]+Math.min(board[i+1][j], board[i][j+1]);
            }
        }
        
        return board[0][0];
    }
}