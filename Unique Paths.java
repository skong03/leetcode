public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] board=new int[m][n];
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(j==n-1||i==m-1){//two side 1, use or
                    board[i][j]=1;
                }
                else
                    board[i][j]=board[i+1][j]+board[i][j+1];
            }
        }
        return board[0][0];
    }
}