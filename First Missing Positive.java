public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        while(i<A.length)
        {
            if(A[i]!=i+1&&A[i]-1>=0&&A[i]<A.length&&A[A[i]-1]!=A[i])
            {//when A[i]!=i+1 && A[i] is in the range of A, and the item need to change is not same
		//the test case [1,1]
                swap(A,i,A[i]-1);
            }
            else
            {
                i++;
            }
        }
        //find first elem which is not equal its index
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


