public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p1 = 0, p2 = A.length-1;
        int p = 0;
        while(p <= p2){
            if(A[p] == 0){
                swap(A, p++, p1++);
            }
            else if(A[p] == 1){
                p++;
            }
            else{
                swap(A, p, p2--);
            }
        }
    }
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}




public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length <= 1)
            return;
            
        int probe = 0;
        int red = -1;
        int blue = A.length;
        
        while(probe < blue){
            if(A[probe] == 0)
                swap(A, probe++, ++red);
            else if(A[probe] == 1)
                probe++;
            else if(A[probe] == 2)
                swap(A, probe, --blue);
        }
    }
    
    private void swap(int[] A, int i,  int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;    
    }
}