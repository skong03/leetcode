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


//Á·Ï°
public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0) return 0;
        int index = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] != A[index]){
                index++;
                A[index] = A[i];
            }
        }
        return index+1;
    }
}




public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0)
            return 0;
        
        int index = 0;
        int element = A[index];
        for(int i=0; i<A.length; i++)
            if(A[i] != element){
                index++;
                A[index] = A[i];
                element = A[i];
            }
            
        return index+1;
    }
}