public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        
        int left = 0, right = n-1, up = 0, down = n-1, val = 1;
        while(true){
            for(int i=left; i<=right; i++) matrix[up][i] = val++;
            if(++up > down) break;
            for(int i=up; i<=down; i++) matrix[i][right] = val++;
            if(--right < left) break;
            for(int i=right; i>=left; i--) matrix[down][i] = val++;
            if(--down < up) break;
            for(int i=down; i>=up; i--) matrix[i][left] = val++;
            if(++left > right) break;
        }
        return matrix;
    }
}