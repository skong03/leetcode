public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        boolean[] v=new boolean[num.length];
        Arrays.sort(num);
        dfs(res,temp,num,v);
        
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp,int[] num, boolean[] v)
    {
        if(temp.size()==num.length)
        {
            if(!res.contains(temp))
                res.add(new ArrayList<Integer>(temp));
        }
        
        for(int i=0;i<num.length;i++)
        {
            if(!v[i])
            {
                v[i]=true;
                temp.add(num[i]);
                dfs(res,temp,num,v);
                temp.remove(temp.size()-1);
                v[i]=false;
                while(i+1<num.length&&num[i]==num[i+1])
                    i++;
            }
        }
    }
}