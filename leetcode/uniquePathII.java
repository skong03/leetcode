//一维DP法
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n+1];
        if(obstacleGrid[0][0] == 0) dp[1] = 1;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[j+1] = obstacleGrid[i][j]==1?0:dp[j]+dp[j+1];
        return dp[n];
    }
}

//二维DP法
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];
        }
        for(int j=1; j<n; j++){
            if(obstacleGrid[0][j] == 1) dp[0][j] = 0;
            else dp[0][j] = dp[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

//递归法
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m==1 && n==1) return 1;
        if(m==1 || n==1) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
}