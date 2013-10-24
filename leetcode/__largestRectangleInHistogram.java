


























public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length < 1)
            return 0;
        
        int[] res = new int[height.length];
        
        for(int i=0; i<height.length; i++){
            int pos = i + 1;
            while(pos < height.length){
                if(height[pos] >= height[i])
                    pos++;
                else
                    break;
            }
            
            int pos2 = i - 1;
            while(pos2 >= 0){
                if(height[pos2] >= height[i])
                    pos2--;
                else
                    break;
            }
            
            res[i] = (pos-pos2-1)*height[i];
        }
        
        Arrays.sort(res);
        return res[res.length-1];
    }
}