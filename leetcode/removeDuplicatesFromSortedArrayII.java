public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0) return 0;
        int index = 0, i = 0;
		
		//这一步很关键
        if(A.length>1 && A[0]==A[1]){
            index = 1;
            i = 1;
        }
		
        for(; i<A.length; i++){
            if(A[index] != A[i]){
                index++;
                A[index] = A[i];
                if(i+1<A.length && A[i+1]==A[i]){
                    index++;
                    A[index] = A[i+1];
                }
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
        if(A.length == 1)
            return 1;
        int index = -1;
        int element = Integer.MIN_VALUE;
        
        for(int i=0; i<A.length; i++){
            if(A[i] != element){
                index++;
                A[index] = A[i];
                element = A[i];
                if(i+1 < A.length && A[i+1] == element){
                    index++;
                    A[index] = A[i+1];
                    element = A[i+1];
                }
            }
        }
        
        return index+1;
    }
}