public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<3)
            return A.length;
        int left=1;
        int count=1;
//both left and right from 1, if right == right-1, count++
//only the first number and the first two number need to be put into left, others, just go right
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