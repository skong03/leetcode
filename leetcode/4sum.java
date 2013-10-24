public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> al = new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a;
        Arrays.sort(num);
        
        if(num.length < 4)
            return al;
        
        for(int i=0; i<num.length-3; i++){
            if(i > 0 && num[i] == num[i-1])
                continue;
            for(int j=i+1; j<num.length-2; j++){
                if(j > i + 1 && num[j] == num[j-1])
                    continue;
                for(int k=j+1; k<num.length-1; k++){
                    if(k > j + 1 && num[k] == num[k-1])
                        continue;
                    int start = k + 1;
                    int end = num.length - 1;
                    int targetV = target - (num[i] + num[j] + num[k]);
                    if(num[start] > targetV || num[end] < targetV)
                        continue;
                    while(start <= end){
                        int mid = (start + end)/2;
                        if(num[mid] < targetV)
                            start = mid + 1;
                        else if(num[mid] > targetV)
                            end = mid - 1;
                        else{
                            a = new ArrayList<Integer>();
                            a.add(num[i]);
                            a.add(num[j]);
                            a.add(num[k]);
                            a.add(num[mid]);
                            al.add(a);
                            break;
                        }
                    }
                }
            }
        }
        
        return al;
    }
}