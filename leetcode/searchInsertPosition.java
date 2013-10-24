public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = A.length - 1;
        int mid = (i+j)/2;
        while(i <= j){
            mid = (i+j)/2;
            if(target < A[mid]) j = mid-1;
            else if(target > A[mid])    i = mid+1;
            else    return mid;
        }
        return i;
    }
}