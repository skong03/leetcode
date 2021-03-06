public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return dfs(A,0,A.length-1,target);
    }
    
    public int dfs(int[] A, int left, int right, int target)
    {
        int mid=(left+right)/2;
        if(A[mid]==target)
            return mid;
            
        if(left > right)//don't find answer don't need '='
            return -1;

        if(A[mid]>=A[left])//all need '=' remember this, easy to make mistake
        {
            if(target>=A[left]&&target<=A[mid])//must write the first condition
                return dfs(A,left,mid-1,target);
            else 
                return dfs(A,mid+1,right,target);
        }else{
            if(target<=A[right]&&target>=A[mid])
                return dfs(A,mid+1,right,target);
            else
                return dfs(A,left,mid-1,target);
        }
    }
}
//II
public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return dfs(A,0,A.length-1,target);
    }
    
    public int dfs(int[] A, int left, int right, int target)
    {
        int mid=(left+right)/2;
        if(A[mid]==target)
            return mid;
            
        if(left > right)//don't find answer don't need '='
            return -1;

        if(A[mid]>A[left])
        {
            if(target>=A[left]&&target<A[mid])//must write the first condition, don't forget the ==
                return dfs(A,left,mid-1,target);
            else 
                return dfs(A,mid+1,right,target);
        }else if(A[mid]<A[left]){
            if(target<=A[right]&&target>A[mid])
                return dfs(A,mid+1,right,target);
            else
                return dfs(A,left,mid-1,target);
        }else
		return dfs(A,left+1,right,target);//different from the I
    }
}