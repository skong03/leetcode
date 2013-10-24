//正确解法，log(m+n)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length, n = matrix[0].length, left = 0, right = m*n-1;
        while(left <= right){
            int mid = (left + right)/2;
            int i = mid/n, j = mid%n;
            if(target == matrix[i][j]) return true;
            else if(target > matrix[i][j]) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}


//有问题的解法，log(m)*log(n)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length, n = matrix[0].length;
        int up = 0, bot = m-1;
        while(up <= bot){
            int mid = (up + bot)/2;
            if(target > matrix[mid][0]) up = mid+1;
            else bot = mid-1;
        }
        int left = 0, right = m-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target == matrix[up][mid]) return true;
            else if(target > matrix[up][mid]) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}



public class Solution {  
    public boolean searchMatrix(int[][] matrix, int target) {  
        int start = 0;  
        int row = matrix.length;  
        int col = matrix[0].length;  
        int end = row * col - 1;  
        while(start<=end){  
            int mid = (start+end)/2;  
            int i = mid/col;  
            int j = mid%col;  
            if (target == matrix[i][j]) return true;  
            else if (target > matrix[i][j]) start = mid + 1;  
            else end = mid - 1;  
        }  
        return false;  
    }  
}  