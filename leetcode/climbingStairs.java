public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            if(i==0) dp[i] = 1;
            else if(i==1) dp[i] = 2;
            else dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[n];
        return recImp(dp, n-1);
    }
    private int recImp(int[] dp, int n){
        if(n == 0) dp[n] = 1;
        if(n == 1) dp[n] = 2;
        if(dp[n] != 0) return dp[n];
        dp[n] = recImp(dp, n-1) + recImp(dp, n-2);
        return dp[n];
    }
}

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}


public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 3)
            return n;
        
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        
        for(int i=2; i<n; i++){
            res[i] = res[i-1] + res[i-2];
        }
        
        return res[n-1];
    }
}