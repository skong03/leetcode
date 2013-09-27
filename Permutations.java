public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
		HashSet<Integer> myset=new HashSet<Integer>();
		for(int i: num)
		{myset.add(i);}
		
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp= new ArrayList<Integer>();
		dfs(myset,res, temp);
		
		return res;
		
	}
	
	public void dfs(HashSet<Integer> myset,  ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp)
	{
		if(myset.isEmpty())
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		HashSet<Integer> newset=new HashSet<Integer>(myset);
		for(int i: myset)
		{
			temp.add(i);
			newset.remove(i);
			dfs(newset, res,temp);
			newset.add(i);
			//System.out.println(temp.remove(temp.size()-1)+"   i="+i);//+"  "+temp.remove(temp.size()-1));
			temp.remove(new Integer(i));
		}
	}
}



public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Arrays.sort(num);
        boolean[] v=new boolean[num.length];
        dfs(res,temp,num,v);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp,int[] num,boolean[] v){
        if(temp.size()==num.length)
        {
                res.add(new ArrayList<Integer>(temp));
                return;
        }
        
        for(int i=0;i<num.length;i++)
        {
            if(v[i]==false)
            {
                temp.add(num[i]);
                v[i]=true;
                dfs(res,temp,num,v);
                v[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}