public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = A.length, len2 = B.length, total = len1+len2;
        if(total%2 == 1) return findK(A, len1, B, len2, total/2+1);
        else return (findK(A, len1, B, len2, total/2+1) + findK(A, len1, B, len2, total/2))/2;
    }
    private double findK(int[] A, int len1, int[] B, int len2, int k){
        if(len1 > len2) return findK(B, len2, A, len1, k);
        if(len1 == 0) return B[k-1];
        if(k == 1) return Math.min(A[0], B[0]);
        int pa = Math.min(k/2, len1), pb = k-pa;
        if(A[pa-1] < B[pb-1]) return findK(Arrays.copyOfRange(A, pa, len1), len1-pa, B, len2, k-pa);
        else return findK(A, len1, Arrays.copyOfRange(B, pb, len2), len2-pb, k-pb);
    }
}


public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = A.length, len2 = B.length, total = len1 + len2;
        if(total%2 == 1) return findK(A, len1, B, len2, total/2+1);
        else return (findK(A, len1, B, len2, total/2+1)+findK(A, len1, B, len2, total/2))/2;
    }
    private double findK(int[] A, int len1, int[] B, int len2, int k){
        if(len1 > len2) return findK(B, len2, A, len1, k);
        if(len1 == 0) return B[k-1];
        if(k == 1) return Math.min(A[0], B[0]);
        int pa = Math.min(k/2, len1), pb = k-pa;
        if(A[pa-1] < B[pb-1]) return findK(Arrays.copyOfRange(A, pa, len1), len1-pa, B, len2, k-pa);
        else return findK(A, len1, Arrays.copyOfRange(B, pb, len2), len2-pb, k-pb);
    }
}

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = A.length, len2 = B.length, total  = len1 + len2;
        if(total%2 == 1) return findK(A, len1, B, len2, total/2+1);
        else return (findK(A, len1, B, len2, total/2+1) + findK(A, len1, B, len2, total/2))/2;
    }
    private double findK(int[] A, int len1, int[] B, int len2, int k){
        if(len1 > len2) return findK(B, len2, A, len1, k);
        if(len1 == 0) return B[k-1];
        if(k == 1) return Math.min(A[0], B[0]);
        int pa = Math.min(k/2, len1), pb = k-pa;
        if(A[pa-1]<B[pb-1]) return findK(Arrays.copyOfRange(A, pa, len1), len1-pa, B, len2, k-pa);
        else return findK(A, len1, Arrays.copyOfRange(B, pb, len2), len2-pb, k-pb);
    }
}

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = A.length, len2 = B.length;
        int total = len1 + len2;
        if(total%2 == 1) return findK(A, len1, B, len2, total/2+1);
        else return (findK(A, len1, B, len2, total/2) + findK(A, len1, B, len2, total/2+1))/2;
    }
    private double findK(int[] A, int len1, int[] B, int len2, int k){
        if(len1 > len2) return findK(B, len2, A, len1, k);
        if(len1 == 0) return B[k-1];
        if(k == 1) return Math.min(A[0], B[0]);
        int pa = Math.min(k/2, len1), pb = k - pa;
        if(A[pa-1] < B[pb-1]) return findK(Arrays.copyOfRange(A, pa, len1), len1-pa, B, len2, k-pa);
        else return findK(A, len1, Arrays.copyOfRange(B, pb, len2), len2-pb, k-pb);
    }
}



//find k-th path
public class Solution {
    
	private double findKth(int a[], int m, int b[], int n, int k)
	{
		if (m > n) return findKth(b, n, a, m, k);

		if (m == 0) return b[k-1];
		if (k == 1) return Math.min(a[0], b[0]);
		int pa = Math.min(k/2, m), pb = k - pa;
		if (a[pa-1] < b[pb-1]) return findKth(Arrays.copyOfRange(a,pa,a.length), m-pa, b, n, k - pa);
		return findKth(a, m, Arrays.copyOfRange(b,pb,b.length), n-pb, k-pb);
	}
    
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length;
        int n = B.length;
		int total = m+n;
		if (total%2==1)
			return findKth(A, m, B, n, total/2+1);
		else
			return (findKth(A, m, B, n, total/2) + findKth(A, m, B, n, total/2+1))/2;
	}
} 





//binary and merge
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
      int m = A.length; 
      int n = B.length;
      if ( m == 0 ) return simpleMedian(B);
      if ( n == 0 ) return simpleMedian(A);
      
      return medianSearch(A,
                          B,
                          Math.max(0,(m+n)/2-n),
                          Math.min(m-1,(m+n)/2));
    }
    
    private double medianSearch(int A[], int B[], int left, int right){
        int m = A.length;
        int n = B.length;        
        
        if (left > right){
            return medianSearch(B,A,Math.max(0,(m+n)/2-m),
                                    Math.min(n-1,(m+n)/2));
        }
        
        int i = (left + right)/2;
        int j = (m+n)/2 - i - 1;
        
        boolean lvalid = (j < 0) || (A[i] >= B[j]);
        boolean rvalid = ( j >= n-1) || (A[i] <= B[j+1]);
        
        if(lvalid && !rvalid)
          return medianSearch(A,B,left,i-1);
        else if(rvalid && !lvalid)
          return medianSearch(A,B,i+1,right);
        
        if( (m+n)%2 == 1) return A[i];
        if ( i > 0){
          int pre = ( j < 0) ? A[i-1]:Math.max(A[i-1],B[j]);
          return (A[i]+pre)/2.0;
        }
        
        return (A[i] + B[j])/2.0;        
    }
	
	private double simpleMedian(int A[]){
        int n = A.length;
        if ( n%2 == 1) return A[n/2];
        return (A[n/2-1] + A[n/2])/2.0;
        
    }
}












public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = 0;
        int cnt = 0;
        int[] aux = new int[A.length + B.length];
        
        while(i < A.length && j < B.length){
            if(A[i] < B[j])
                aux[cnt++] = A[i++];
            else
                aux[cnt++] = B[j++];
        }
        
        while(i < A.length)
            aux[cnt++] = A[i++];
        while(j < B.length)
            aux[cnt++] = B[j++];
        
        int mid = (aux.length-1)/2;
        
        if((aux.length % 2) == 1)
            return aux[mid];
        else
            return (double)(aux[mid] + aux[mid+1])/2;
    }
}