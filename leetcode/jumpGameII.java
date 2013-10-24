public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int step = 0;
        int maxDistance = 0;
        int range = 0;
        
        for(int i=0; i<A.length; i++){
            if(i > range){
                range = maxDistance;
                step++;
            }
            maxDistance = Math.max(maxDistance, i + A[i]);
        }
        
        return step;
    }
}