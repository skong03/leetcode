//ÕýÈ·
public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = A.length-1;
        int mid;
        while(left <= right){
            mid = (left+right)/2;
            if(A[mid] == target) return mid;
            if(A[left] <= A[mid]){
                if(target<A[mid] && target>=A[left]) right = mid-1;
                else left = mid+1;
            }
            else{
                if(target>A[mid] && target<=A[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
}




public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = A.length-1;
        int mid;
        while(left <= right){
            mid = (left+right)/2;
            if(A[mid] == target)
                return mid;
            if(A[left] <= A[mid]){
                if(target>=A[left] && target<A[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
            else{
                if(target>A[mid] && target<=A[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
}