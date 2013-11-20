public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int maxleft=0;
        int maxright=0;
        int left=0;
        int right=A.length-1;
        int sum=0;
        while(left<=right){
            maxleft=Math.max(A[left],maxleft);//first get the maxvalue of left and right
            maxright=Math.max(A[right],maxright);
            
            if(maxleft<maxright){//if maxleft<maxright, move the point left
                if(A[left]<maxleft){
                    sum+=maxleft-A[left];
                }
                left++;
            }else {
                if(A[right]<maxright)
                    sum+=maxright-A[right];
                right--;
            }
        }
        return sum;
        
    }
}
