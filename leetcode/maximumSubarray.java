
public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0) return 0;
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for(int i=0; i<A.length; i++){
            if(i>0){
                int tmp = A[i] + dp[i-1];
                if(tmp>=0 && dp[i-1]>=0) dp[i] = tmp;
                else dp[i] = A[i];
            }
        }
        Arrays.sort(dp);
        return dp[A.length-1];
    }
}



public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxNow = 0;
        int maxAll = A[0];
        
        for(int i=0; i<A.length; i++){
            maxNow = Math.max(0, maxNow + A[i]);
            if(maxNow > 0)
                maxAll = Math.max(maxAll, maxNow);
            else
                maxAll = Math.max(maxAll, A[i]);
        }
        
        return maxAll;
    }
}