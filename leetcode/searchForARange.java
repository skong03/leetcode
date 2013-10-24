public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = A.length-1;
        int[] res = {-1, -1};
        if(A==null || A.length==0) return res;
        while(left <= right){
            int mid = (left+right)/2;
            if(target > A[mid]) left = mid+1;
            else right = mid-1;
        }
        if(left<0 || left>=A.length || A[left]!=target) return res;
        res[0] = left;
        right = A.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(target < A[mid]) right = mid-1;
            else left = mid+1;
        }
        res[1] = right;
        return res;
    }
}






public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = A.length-1;
        int index = -1;
        int[] res = {-1, -1};
        while(i <= j){
            int mid = (i+j)/2;
            if(target < A[mid]) j = mid-1;
            else if(target > A[mid])    i = mid+1;
            else{
                index = mid;
                break;
            }
        }
        
        if(index == -1) return res;
        int start = index, end = index;
        while(start-1 >= 0 && A[start-1] == target)    start--;
        while(end+1 < A.length && A[end+1] == target)  end++;
        res[0] = start;
        res[1] = end;
        return res;
    }
}