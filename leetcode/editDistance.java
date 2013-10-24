public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = word1.length(), n = word2.length();
        int[][] matrix = new int[m+1][n+1];
        matrix[0][0] = 0;
        for(int i=1; i<=m; i++) matrix[i][0] = i;
        for(int j=1; j<=n; j++) matrix[0][j] = j;
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++)
                matrix[i][j] = (word1.charAt(i-1)==word2.charAt(j-1))?matrix[i-1][j-1]:(Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])))+1;
        return matrix[m][n];
    }
}