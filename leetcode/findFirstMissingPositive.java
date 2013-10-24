public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length < 1)
            return 1;
        
        Arrays.sort(A);
        boolean[] flag = new boolean[A.length + 1];
        
        for(int i=0; i<A.length; i++){
            if(A[i] > 0 && A[i] <= A.length)
                flag[A[i]] = true;
        }
        
        for(int i=1; i<=A.length; i++){
            if(flag[i] == false)
                return i;
        }
        
        return A.length+1;
    }
}