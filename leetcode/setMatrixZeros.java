public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix==null || matrix.length==0) return;
        boolean row = false, col = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++)
            if(matrix[i][0]==0) col = true;
        for(int i=0; i<n; i++)
            if(matrix[0][i]==0) row = true;
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++)
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++)
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
        if(row)
            for(int i=0; i<n; i++)
                matrix[0][i] = 0;
        if(col)
            for(int i=0; i<m; i++)
                matrix[i][0] = 0;
    }
}


public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
        for(int i=0; i<m; i++)
            if(row[i])
                for(int j=0; j<n; j++)
                    matrix[i][j] = 0;
        for(int i=0; i<n; i++)
            if(col[i])
                for(int j=0; j<m; j++)
                    matrix[j][i] = 0;
    }
}


public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean row = false, col = false;
        for(int i=0; i<matrix[0].length; i++)
            if(matrix[0][i] == 0){
                row = true;
                break;
            }
        for(int i=0; i<matrix.length; i++)
            if(matrix[i][0] == 0){
                col = true;
                break;
            }
            
        for(int i=1; i<matrix.length; i++)
            for(int j=1; j<matrix[0].length; j++)
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
                
        for(int i=1; i<matrix.length; i++)
            for(int j=1; j<matrix[0].length; j++)
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        
        if(row)
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        if(col)
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
    }
}