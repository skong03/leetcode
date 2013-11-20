public class Solution {
    public int jump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] dp=new int[A.length];
        for(int i=A.length-2;i>=0;i--){
            if(A[i]==0)
                dp[i]=0;
            else if(A[i]+i>=A.length-1)
                dp[i]=1;
            else{
                int min=A.length;//Integer.MAX_VALUE+1 maybe overflow
                for(int j=1;j<=A[i];j++){
                    if(dp[i+j]!=0)
                        min=Math.min(dp[i+j],min);
                }
                if(min==A.length)//if min==length, can't reach 
                    dp[i]=0;
                else
                    dp[i]=min+1;
            }
        }
        return dp[0];
    }
}