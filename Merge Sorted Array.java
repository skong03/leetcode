public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p1=m-1;
        int p2=n-1;
        int p3=m+n-1;
        if(n==0)
            return;
        
        while(p1>=0&&p2>=0)
        {
            if(A[p1]>=B[p2])
                {
                    A[p3]=A[p1];
                    p3--;
                    p1--;
                }
            else
                {
                    A[p3]=B[p2];
                    p3--;
                    p2--;
                }
        }
        
        if(p1<0){
            while(p2>=0)
            {
                A[p3]=B[p2];
                p3--;
                p2--;
            }
        }
        else
        {
            while(p1>=0)
            {
                A[p3]=A[p1];
                p3--;
                p1--;
            }
        }
        
    }




public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p1=m-1, p2=n-1, p3=m+n-1;
        
        while(p1>=0&&p2>=0)
        {
            if(A[p1]>=B[p2])
            {
                A[p3]=A[p1];
                p1--;
                p3--;
            }
            else
            {
                A[p3]=B[p2];
                p2--;
                p3--;
            }
        }
        while(p2>=0)
        {
		    A[p3]=B[p2];
		    p3--;
		    p2--;
	    }
       
    }
}
}