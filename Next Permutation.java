public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=num.length-1;
        for(;index>=1;index--)
        {
            if(num[index-1]>=num[index])
                continue;
            else
                break;
        }
        
        reverse(num, index, num.length-1);
        
        int pre=index-1;
        for(;index<=num.length-1;index++) //be care for the the"="
        {
            if(pre>=0&&num[pre]<num[index])//be care for the the "="
            {
                swap(num, pre, index);
                break;
            }
        }
        
    }
    
    public void reverse(int[] num, int low, int high)
    {
        while(low<high)
        {
            swap(num, low, high);
            low++;
            high--;
        }
    }
    
    public void swap(int[] num, int a, int b)
    {
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
}