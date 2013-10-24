public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()==0) return 0;
        int len = s.length();
        boolean[][] matrix = createTable(s);
        int[] dp = new int[len+1];
        for(int i=len-1; i>=0; i--){
            dp[i] = len - i;
            for(int j=i; j<len; j++){
                if(matrix[i][j]) dp[i] = Math.min(dp[i], dp[j+1]+1);
            }
        }
        return dp[0]-1;
    }
    private boolean[][] createTable(String str){
        int len = str.length();
        boolean[][] matrix = new boolean[len][len];
        for(int i=0; i<len; i++) matrix[i][i] = true;
        for(int i=0; i<len; i++){
            int r = i, c = i+1;
            while(r>=0 && r<len && c>=0 && c<len && str.charAt(r)==str.charAt(c)){
                matrix[r][c] = true;
                r--;
                c++;
            }
            r = i-1;
            c = i+1;
            while(r>=0 && r<len && c>=0 && c<len && str.charAt(r)==str.charAt(c)){
                matrix[r][c] = true;
                r--;
                c++;
            }
        }
        return matrix;
    }
}





public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] matrix = createDP(s);
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 0;
        for(int i=s.length()-1; i>=0; i--){
            dp[i] = s.length() - i;
            for(int j=i; j<s.length(); j++){
                if(matrix[i][j]) dp[i] = Math.min(1+dp[j+1], dp[i]);
            }
        }
        return dp[0]-1;
    }
    private boolean[][] createDP(String s){
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        for(int i=0; i<len; i++) matrix[i][i] = true;
        for(int i=0; i<len; i++){
            int r = i, c = i+1;
            while(r>=0 && r<len && c>=0 && c<len && s.charAt(r)==s.charAt(c)){
                matrix[r][c] = true;
                r--;
                c++;
            }
            r = i-1;
            c = i+1;
             while(r>=0 && r<len && c>=0 && c<len && s.charAt(r)==s.charAt(c)){
                matrix[r][c] = true;
                r--;
                c++;
            }
        }
        return matrix;
    }
}



public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] mem = new boolean[s.length()][s.length()];
        int[] min = new int[s.length()+1];
        
        for(int i=s.length(); i>=0; i--)
            min[i] = s.length() - i;
        
		//This is the same alg with the previous PalinPartitionI.
		//But this combines all the comparison jobs into one "if(...)",
		//which is very brilliant.
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || mem[i+1][j-1])){
                    mem[i][j] = true;
                    min[i] = Math.min(min[i], min[j+1]+1);
                }
            }
        }
        
        return min[0] - 1;
    }
}