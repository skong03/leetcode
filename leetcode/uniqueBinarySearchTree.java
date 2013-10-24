//´¿µÝ¹é
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = 0;
        if(n == 0 || n == 1) return 1;
        else
            for(int i=0; i<n; i++)
                sum += numTrees(i)*numTrees(n-i-1);
        return sum;
    }
}

//Ë³ÐòDP
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++)
                dp[i] += dp[j]*dp[i-1-j];
        }
        return dp[n];
    }
}

//µÝ¹éDP
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[n+1];
        
        return recImp(dp, n);
    }
    private int recImp(int[] dp, int n){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != 0) return dp[n];
        for(int i=0; i<n; i++)
            dp[n] += recImp(dp, i)*recImp(dp, n-1-i);
        return dp[n];
    }
}




//Á·Ï°
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0 || n==1) return 1;
        int res = 0;
        for(int i=0; i<n; i++)
            res += numTrees(i)*numTrees(n-i-1);
        return res;
    }
}








