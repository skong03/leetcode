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