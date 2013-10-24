public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int end = A.length-1;
        for(int i=end; i>=0; i--){
            if(A[i] == elem){
                swap(A, i, end);
                end--;
            }
        }
        
        return end+1;
    }
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}



public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0, right = A.length-1;
        while(left <= right){
            if(A[left] != elem) left++;
            else swap(A, left, right);
            while(left<=right && A[right]==elem) right--;
        }
        return left;
    }
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}