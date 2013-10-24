public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String res = "";
        String tmp = "";
        
        for(int i=0; i<s.length(); i++){
            tmp = getPalindrome(s, i, i);
            if(tmp.length() > res.length())
                res = tmp;
            
            tmp = getPalindrome(s, i, i+1);
            if(tmp.length() > res.length())
                res = tmp;
        }
        
        return res;
    }
    
    private String getPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}


//下面是时间空间均为n平方的解法
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        for(int i=0; i<n; i++)
            matrix[i][i] = true;
        
        int start = 0;
        int maxLen = 1;
        for(int i=0; i<n-1; i++)
            if(s.charAt(i) == s.charAt(i+1)){
                matrix[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        
        for(int len=3; len<=n; len++)
            for(int i=0; i<n-len+1; i++){
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]){
                    matrix[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        
        return s.substring(start, start+maxLen);
    }
}









