public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cmp = Math.abs(num[0] + num[1] + num[2] - target);
        int x = num[0] + num[1] + num[2];
        for(int i=0; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                for(int k=j+1; k<num.length; k++){
                    if(Math.abs(num[i] + num[j] + num[k] - target) <= cmp){
                        cmp =  Math.abs(num[i] + num[j] + num[k] - target);
                        x = num[i] + num[j] + num[k];
                    }                    
                }
            }
        }
        return x;
    }
}


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int cmp = Math.abs(num[0] + num[1] + num[2] - target);
        int x = num[0] + num[1] + num[2];
        
        for(int i=0; i<num.length; i++){
            if(i > 0 && num[i] == num[i-1])
                continue;
            for(int j=i+1; j<num.length; j++){
                if(j > i+1 && num[j] == num[j-1])
                    continue;
                int start = j + 1;
                int end = num.length - 1;
                while(start <= end){
                    int mid = (start + end)/2;
                    if(Math.abs(num[i] + num[j] + num[mid] - target) < cmp){
                        cmp = Math.abs(num[i] + num[j] + num[mid] - target);
                        x = num[i] + num[j] + num[mid];
                    }
                    if((num[i] + num[j] + num[mid] - target) < 0)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
        }
        
        return x;
    }
}