//解法新颖，构思缜密
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return res;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n-1, up = 0, down = m-1;
        while(true){
            for(int i=left; i<=right; i++){
                res.add(matrix[up][i]);
            }
            if(++up > down) break;
            for(int i=up; i<=down; i++){
                res.add(matrix[i][right]);
            }
            if(--right < left) break;
            for(int i=right; i>=left; i--){
                res.add(matrix[down][i]);
            }
            if(--down < up) break;
            for(int i=down; i>=up; i--){
                res.add(matrix[i][left]);
            }
            if(++left > right) break;
        }
        return res;
    }
}