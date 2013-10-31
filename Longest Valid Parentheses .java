public class Solution {
    public int longestValidParentheses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n=s.length();
        if(n==0)
            return 0;
        int[] dp=new int[n];
        int max=0;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='('){
                int j=i+1+dp[i+1];//find the right position, dp[i+1] number of valid parentheses on position i+1
                if(j<n&&s.charAt(j)==')'){
                    dp[i]=dp[i+1]+2;//if valid, dp[i+1]+2
                    if(j+1<n)//maybe j+1 is also valid, then you need to plus that
                        dp[i]+=dp[j+1];
                }
                max=Math.max(max,dp[i]);
            }
        }
        
        return max;
    }
}