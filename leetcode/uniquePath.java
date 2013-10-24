//一维DP法
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=0; i<m; i++)
            for(int j=1; j<n; j++)
                dp[j] = dp[j] + dp[j-1];
        return dp[n-1];
    }
}


//二维DP法
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++) matrix[i][0] = 1;
        for(int i=0; i<n; i++) matrix[0][i] = 1;
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++)
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        return matrix[m-1][n-1];
    }
}




public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
            for(int j=0; j<n; j++){
                dp[0][j] = 1;
                if(i>0 && j>0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}





