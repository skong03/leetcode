public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0)
            return 0;
        int res = 0;
        int start = 0, end = A.length-1;
        while(start < end){
            if(A[start] <= A[end]){
                int k = start+1;
                while(A[k] < A[start]){
                    res += A[start]-A[k];
                    k++;
                }
                start = k;
            }
            else{
                int k = end - 1;
                while(A[k] < A[end]){
                    res += A[end] - A[k];
                    k--;
                }
                end = k;
            }
        }
        
        return res;
    }
}