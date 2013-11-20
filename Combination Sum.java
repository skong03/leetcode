public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res, temp,target, candidates,0);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int target, int[] n,int pos)
    {
        if(target<0)
            return;
        if(target==0)
        {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
            
        for(int i=pos;i<n.length;i++)//you make mistake here, forget i
        {
            temp.add(n[i]);
            dfs(res,temp,target-n[i],n,i);
            temp.remove(new Integer(n[i]));
        }
    }
}