package coinchange;

import java.util.HashMap;

public class coinchange {
	int[] coin={25,11,5,1};
	HashMap<String, Integer> table;
	coinchange(){
		table=new HashMap<String,Integer>();
	}
	public int makechange(int num){
		return makechange(num,0);
	}
	
	public int makechange(int num, int pos){
		String key=num+","+pos;
		if(table.containsKey(key))
			return table.get(key);
		int step=0;
		if(pos>coin.length-1||num<0){
			step=0;
		}else if(num==0){
			step=1;
		}else{
			step=makechange(num,pos+1)+makechange(num-coin[pos],pos);
		}
		
		table.put(key,step);
		return step;
	}
}
