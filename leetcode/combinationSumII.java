public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(num);
        
        recImp(res, tmp, num, target, 0);
        
        return res;
    }
    
    private void recImp(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int target, int pos){
        if(target < 0)
            return;
        if(target == 0){
            if(!res.contains(tmp))
                res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=pos; i<num.length; i++){
            tmp.add(num[i]);
            recImp(res, tmp, num, target-num[i], i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}