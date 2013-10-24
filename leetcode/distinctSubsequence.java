//递归法
public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S.length()==0) return T.length()==0?1:0;
        if(T.length()==0) return 1;
        int res = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)==T.charAt(0))
                res += numDistinct(S.substring(i+1), T.substring(1));
        }
        return res;
    }
}

//二维DP法
public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = S.length()+1, n = T.length()+1;
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++) matrix[i][0] = 1;
        for(int j=1; j<n; j++) matrix[0][j] = 0;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                matrix[i][j] = matrix[i-1][j] + (S.charAt(i-1)==T.charAt(j-1)?matrix[i-1][j-1]:0);
            }
        }
        return matrix[m-1][n-1];
    }
}



//看不懂的一维DP法
public class Solution {
   public int numDistinct(String S, String T) {
        int[] occurence = new int[T.length() + 1];
        occurence[0] = 1;
        for(int i = 0; i < S.length(); i++){
            for(int j = T.length() - 1; j >= 0 ; j--)
                if(S.charAt(i) == T.charAt(j)){
                    if(occurence[j] > 0)
                        occurence[j + 1] += occurence[j];
                }
        }
        return occurence[T.length()];
    }
}