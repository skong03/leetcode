public class Solution {
    public int divide(int dividend, int divisor) {
		long num = Math.abs((long)dividend);
		long div = Math.abs((long)divisor);
		//int div=divisor;
		ArrayList<Integer> al=new ArrayList<Integer>();
		if(div>Integer.MAX_VALUE)
            al.add(Integer.MAX_VALUE);
		while(div<=Integer.MAX_VALUE)
		{
			al.add((int)div);
			div=div<<1;
		}
        
		System.out.println(al);
		int res=0;
		for(int index=al.size()-1;index>=0; index--)
		{
			//res=0;
			res=res<<1;
			while(num>=al.get(index))
			{
				num=num-al.get(index);
				res++;
			}
		}
		if((dividend>=0&&divisor>0)||(dividend<0&&divisor<0))
			return res;
		else return 0-res;
	}
}
