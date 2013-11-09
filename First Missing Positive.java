public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        while(i<A.length)
        {
            if(A[i]!=i+1&&A[i]-1>=0&&A[i]<A.length&&A[A[i]-1]!=A[i])
            {
                swap(A,i,A[i]-1);
            }
            else
            {
                i++;
            }
        }
        
        for(int j=0;j<A.length;j++)
        {
            if(j+1!=A[j])
                return j+1;
        }
        return A.length+1;
    }
    
    public void swap(int[] A, int a, int b)
    {
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}