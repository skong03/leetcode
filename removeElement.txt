public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int end = A.length-1;
        
        for(int i= A.length-1; i>=0; i--)
        {
            if(A[i]==elem)
            {
                swap(A, i, end);
                end--;
            }
        }
        
        return end+1;
    }
    public void swap(int[] a, int i, int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}