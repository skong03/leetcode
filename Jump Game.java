

//this is better
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int next = A.length - 1;
        boolean jumpFlag = true;
        
        for(int i=A.length-2; i>=0; i--){
            if(A[i] >= next - i){
                jumpFlag = true;
                next = i;
            }
            else
                jumpFlag = false;
        }
        
        return jumpFlag;
    }
}