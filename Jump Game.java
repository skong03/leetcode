public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[] can=new boolean[A.length];
        can[A.length-1]=true;
        for(int i=A.length-2;i>=0;i--)
        {
            if(i+A[i]+1>=A.length)
                can[i]=true;
            else if(A[i]==0)
                can[i]=false;
            else
            {
                for(int j=1;j<=A[i];j++)
                {
                    can[i]=can[i]||can[i+j];
//                    if(can[i])
//                        break;
                }
            }
        }
        
        return can[0];
    }
}