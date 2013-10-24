public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res, level, candidates, target, 0, 0);
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> level, int[] A, int target, int pos, int sum){
        if(pos == A.length) return;
        while(sum < target){
            dfs(res, new ArrayList<Integer>(level), A, target, pos+1, sum);
            level.add(A[pos]);
            sum += A[pos];
            if(sum == target){
                res.add(level);
                return;
            }
        }
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        recImp(res, tmp, candidates, target, 0);
        
        return res;
    }
    
    private void recImp(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int sum, int pos){
        if(sum < 0)
            return;
        if(sum == 0){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=pos; i<num.length; i++){
            tmp.add(num[i]);
            recImp(res, tmp, num, sum-num[i], i);
            tmp.remove(tmp.size()-1);
        }
    }
}