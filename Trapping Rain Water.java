public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        int j=A.length-1;
        int left=0;
        int right=0;
        int sum=0;
        while(i<j)
        {
            left=Math.max(left,A[i]);
            right=Math.max(right,A[j]);

            if(left<=right)
            {
                if(A[i]<left)
                    sum=sum+left-A[i];
                
                i++;
            }
            else
            {
                if(A[j]<right)
                    sum=sum+right-A[j];
                j--;
            }
        }
        
        return sum;
    }
}