public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<3)
            return A.length;
        int left=1;
        int count=1;
        for(int right=1;right<A.length;right++)
        {
            if(A[right]==A[right-1])
                count++;
            else
                count=1;
            
            if(count<=2)
            {
                A[left]=A[right];
                left++;
            }
        }
        return left;
    }
}