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



public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(res, temp, num,0);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] num, int pos){
        if(pos==num.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=pos;i<num.length;i++){
            temp.add(num[i]);
            dfs(res,temp,num,i+1);
            temp.remove(temp.size()-1);
            while(i<num.length&&num[i]==num[i+1])
                i++;
        }
    }
}