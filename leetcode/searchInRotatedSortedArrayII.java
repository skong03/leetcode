public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = A.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target == A[mid]) return true;
            if(A[left] < A[mid]){
                if(target>=A[left] && target<A[mid]) right = mid-1;
                else left = mid+1;
            }
            else if(A[left] > A[mid]){
                if(target<=A[right] && target>A[mid]) left = mid+1;
                else right = mid-1;
            }
            else left++;
        }
        return false;
    }
}


//Á·Ï°
public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int head = 0, tail = A.length-1, mid = (head+tail)/2;
        while(head <= tail){
            mid = (head + tail)/2;
            if(A[head] < A[mid]){
                if(target>=A[head] && target<A[mid]) tail = mid-1;
                else head = mid+1;
            }
            else if(A[head] > A[mid]){
                if(target>A[mid] && target<=A[tail]) head = mid+1;
                else tail = mid-1;
            }
            else head++;
            if(A[mid] == target) return true;
        }
        return false;
    }
}


public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = A.length-1;
        int mid;
        while(left <= right){
            mid = (left+right)/2;
            if(target == A[mid])
                return true;
            if(A[left]<A[mid]){
                if(target>=A[left] && target<A[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
            else if(A[left]>A[mid]){
                if(target>A[mid] && target<=A[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else
                left++;
        }
        return false;
    }
}