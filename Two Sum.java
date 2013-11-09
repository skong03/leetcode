public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] res=new int[2];
	HashMap<Integer,Integer> table=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
		if(table.containsKey(numbers[i])){
			res[0]=table.get(numbers[i]);
			res[1]=i;
		}
		else
			table.put(target-numbers[i],i);
	}
        
        return res;
    }
}