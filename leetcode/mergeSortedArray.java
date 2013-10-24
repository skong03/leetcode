public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = m-1, right = n-1, cnt = m+n-1;
        while(left>=0 && right>=0){
            if(A[left]>B[right]) A[cnt--] = A[left--];
            else A[cnt--] = B[right--];
        }
        while(left>=0) A[cnt--] = A[left--];
        while(right>=0) A[cnt--] = B[right--];
    }
}




public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cnt = m+n-1, i = m-1, j = n-1;
        while(i>=0 && j>=0){
            if(A[i] > B[j]) A[cnt--] = A[i--];
            else A[cnt--] = B[j--];
        }
        while(i >= 0) A[cnt--] = A[i--];
        while(j >= 0) A[cnt--] = B[j--];
    }
}


public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] aux = new int[m+n];
        int i = 0;
        int j = 0;
        int cnt = 0;
        
        while(i < m && j < n){
            if(A[i] < B[j])
                aux[cnt++] = A[i++];
            else{
                aux[cnt++] = B[j++];
            }
        }
        while(i < m){
            aux[cnt++] = A[i++];
        }
        while(j < n){
            aux[cnt++] = B[j++];
        }
        
        for(int k=0; k<cnt; k++)
            A[k] = aux[k];
    }
}





public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] aux = new int[m+n];
        int left = 0, right = 0, cnt = 0;
        while(left<m && right<n){
            if(A[left] < B[right]) aux[cnt++] = A[left++];
            else aux[cnt++] = B[right++];
        }
        while(left < m) aux[cnt++] = A[left++];
        while(right < n) aux[cnt++] = B[right++];
        for(int i=0; i<cnt; i++)
            A[i] = aux[i];
    }
}