public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>> ();
        Stack<Integer> s=new Stack<Integer>();
        
        find(res, s, 1, n, k);
        return res;
        
    }
    
    public void find(ArrayList<ArrayList<Integer>> res, Stack<Integer> s, int index,int n, int k)
    {
        if(k==0)
        {
            ArrayList<Integer> ary=new ArrayList<Integer>();
            for(int i: s)
            {
                ary.add(i);
            }
            res.add(ary);
        }else if(index<=n)//if index>n, still wrong, find(res,s,n,n,k) means choose none before.
        {
            s.push(index);
            find(res, s, index+1, n, k-1);
            s.pop();
            find(res, s, index+1,n,k);
        }else
            return;
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        dfs(res, temp, n, 1, k);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp,int n, int pos, int k){
        if(temp.size()==k){
            res.add(new ArrayList<Integer>);
            break;
        }
        for(int i=pos;i<=n;i++){
            temp.add(i);
            dfs(res,temp,n,i+1,k);
            temp.remove(new Integer(i));
        }
    }
}