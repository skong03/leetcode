public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) return res;
        for(int i=0; i<num.length; i++){
            //if(i>0 && num[i]==num[i-1]) continue;
            while(i>0 && i<num.length && num[i]==num[i-1]) i++;
            int left = i+1, right = num.length-1;
            while(left < right){
                int sum = num[i]+num[left]+num[right];
                if(sum == 0){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[left++]);
                    tmp.add(num[right--]);
                    res.add(tmp);
                    while(left<right && num[left]==num[left-1]) left++;
                    while(left<right && num[right]==num[right+1]) right--;
                }
                else if(sum > 0) right--;
                else left++;
            }
        }
        return res;
    }
}








public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a;
        Arrays.sort(num);
        
        if(num.length < 3)
            return al;
        
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
                    
                    if((num[i] + num[j] + num[mid]) < 0)
                        start = mid + 1;
                    else if((num[i] + num[j] + num[mid]) > 0)
                        end = mid - 1;
                    else{
                        a = new ArrayList<Integer>();
                        a.add(num[i]);
                        a.add(num[j]);
                        a.add(num[mid]);
                        al.add(a);
                        break;
                    }
                }
            }
        }
        return al;
    }
}