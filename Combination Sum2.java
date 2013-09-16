public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        
        dfs(res, temp, num, target, 0);
        return res;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp, int[] num, int target,int pos)
    {
        if(target==0)
        {
            if(!res.contains(temp))
                res.add(new ArrayList<Integer>(temp));
            return;
        }
        if(target<0)
            return;
            
        if(pos>=num.length)
            return;
        
        for(int i=pos; i< num.length;i++)
        {
            temp.add(num[i]);
            dfs(res, temp, num, target-num[i], i+1);
            temp.remove(new Integer(num[i]));
            dfs(res, temp, num, target, i+1);
        }
    }
}