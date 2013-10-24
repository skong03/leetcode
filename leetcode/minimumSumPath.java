//Ò»Î¬DP
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[0] = grid[0][0];
                else if(i == 0) dp[j] = grid[0][j] + dp[j-1];
                else if(j == 0) dp[j] = grid[i][0] + dp[0];
                else dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        return dp[n-1];
    }
}

//¶þÎ¬DP
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1; i<m; i++) dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int j=1; j<n; j++) dp[0][j] = grid[0][j] + dp[0][j-1];
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        return dp[m-1][n-1];                
    }
}