public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=index(A,target,0,A.length-1);
        int j=i;
        while(i>0 && A[i]==A[i-1])
            {i--;}
        while(j>=0 && j+1<=A.length-1&& A[j]==A[j+1])
            {j++;}
        int[] res=new int[2];
        res[0]=i;
        res[1]=j;
        return res;
    }
    
    public int index(int[] A, int target, int left, int right)
    {
        int mid=(left+right)/2;
        if(A[mid]==target)
            return mid;
        if(left>right)
            return -1;
        if(target>A[mid])
            return index(A, target, mid+1, right);
        else
            return index(A,target,left,mid-1);
    }
}