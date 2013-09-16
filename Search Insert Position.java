public class Solution {
    public int searchInsert(int[] A, int target) {
        int low=0;
        int high=A.length;//这里没有减一
        
        while(low<high)
        {
            int mid=(low+high)/2;
            if(A[mid]==target)
                return mid;
            else if(target<A[mid])
                high=mid;
            else
                low=mid+1;//这里是加一
        }
        return low;
    }
}