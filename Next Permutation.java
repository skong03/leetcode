//can't understand
//find the index, which A[index-1]<A[index], reverse(index,A.length),if the index==0, means the last case
//form index-1 to A.length-1, find the fist num>A[index-1], swap(A[index-1],num)
public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=num.length-1;
        for(;index>=1;index--)//find the first number which pre is smaller than cur
        {
            if(num[index-1]>=num[index])
                continue;
            else
                break;
        }
        
        reverse(num, index, num.length-1);//reverse it
        
        int pre=index-1;
        for(;index<=num.length-1;index++) //be care for the the"="
        {
            if(pre>=0&&num[pre]<num[index])//be care for the the "=" can't understand
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


public class Solution {
    public void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int index=num.length-1;
        for(;index>=1;index--){
            if(num[index-1]<num[index]){
                reverse(num,index,num.length-1);
                break;
            }
        }
        if(index==0){//if the index is 0, it means last case, reverse all, get the answer
            reverse(num,index,num.length-1);
            return;
        }
        
        int pre=index-1;
        for(;index<num.length;index++){
            if(pre>=0&&num[pre]<num[index]){
                swap(num,pre,index);
                break;
            }
        }
    }
    
    public void reverse(int[] num, int a, int b){
        while(a<b){
            swap(num,a,b);
            a++;
            b--;
        }
    }
    
    public void swap(int[] A, int a, int b){
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}