public class Solution {
    public int searchInsert(int[] A, int target) {
        int low=0;
        int high=A.length;//
        
        while(low<high)
        {
            int mid=(low+high)/2;
            if(A[mid]==target)
                return mid;
            else if(target<A[mid])
                high=mid;
            else
                low=mid+1;//
        }
        return low;
    }
}

public class Solution {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        return find(A, 0, A.length-1, target);
    }
    
    public int find(int[] A, int left, int right, int target){
        if(left>right)
            return left;//different with search, here retrun left, not -1******
        int mid=(left+right)/2;
        if(A[mid]==target)
            return mid;
        if(A[mid]>target)
            return find(A, left, mid-1, target);
        else
            return find(A, mid+1,right,target);
    }
}