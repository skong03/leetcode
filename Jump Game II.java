public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] table=new int[A.length];
        table[A.length-1]=0;
        
        for(int i=A.length-2;i>=0;i--)
        {
            if(A[i]==0)
                table[i]=0;
            else if(A[i]==1&&table[i+1]!=0)
                table[i]=table[i+1]+1;
            else if(i+A[i]>=A.length-1)
                table[i]=1;
            else
            {
                int min=A.length;//Integer.MAX_VALUE+1 maybe overflow
                for(int j=1;j<=A[i];j++)
                {
                    if(table[i+j]!=0)
                        min=Math.min(table[i+j],min);
                }
                table[i]=min+1;
            }
        }
        return table[0];
    }
}