
//this method is much easy understand, use this one
public class Solution {  
    public int removeDuplicates(int[] A) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        if(A==null || A.length==0) return 0;  
        int index = 0;  
        for(int i=0; i<A.length; i++)  
            if(A[i]!=A[index]){  
                index++;  
                A[index] = A[i];  
            }  
        return index+1;  
    }  
} 


public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length==0)
            return 0;
        int slow=0;
        for(int fast=0;fast<A.length;fast++){
            if(A[slow]!=A[fast]){
                slow++;
                A[slow]=A[fast];
            }
        }
        return slow+1;
    }
}