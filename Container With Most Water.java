public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low=0;
        int high=height.length-1;
        
        int max=0;
        while(low<high)
        {
            max=Math.max(max,(high-low)*Math.min(height[low],height[high]));
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        
        return max;
    }
}