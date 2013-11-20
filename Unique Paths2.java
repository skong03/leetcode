public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] board=new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1&&j==n-1&&obstacleGrid[i][j]!=1)
                    board[i][j]=1;
                else if(obstacleGrid[i][j]==1)
                    board[i][j]=0;
                else
                    board[i][j]=board[i+1][j]+board[i][j+1];
            }
        }
        
        return board[0][0];
    }
}

//1. the extend side
//2. the obstacle
//3. the destination
//4. the regural grid

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] board=new int[m+1][n+1];
        
        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==m||j==n){ 
                    board[i][j]=0;
                }else if(obstacleGrid[i][j]==1)
                    board[i][j]=0;
                else if(i==m-1&&j==n-1)
                    board[i][j]=1;
                else
                    board[i][j]=board[i+1][j]+board[i][j+1];
            }
        }
        return board[0][0];
    }
}