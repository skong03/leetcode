public class Solution {
    public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0)
			return 0;

		int p1 = 0;
		int p2 = 0;

		while (p1 < A.length - 1) {
			if (A[p1] == A[p1 + 1])
				p1++;
			else {
				A[p2+1] = A[p1+1];//easy to make mistake
				p2++;
				p1++;
			}
		}

		return p2+1;
	}
}

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