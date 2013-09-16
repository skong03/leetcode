public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p0=0;
        int p1=0;
        int p2=A.length-1;
        
        while(p1<=p2)
        {
            if(A[p1]==0)
            {
                swap(A,p1,p0);
                p1++;
                p0++;
            }
            else if(A[p1]==2)
            {
                swap(A,p1,p2);
                //p1++;
                p2--;
            }
            else
                p1++;
        }
        
    }
    
    public void swap(int[] A, int a, int b)
    {
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}