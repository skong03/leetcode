public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,Integer> mymap=new HashMap<Integer, Integer>();
        int low=0;
        int high=0;
        for(int i:num)
        {
            if(mymap.containsKey(i))
                continue;
            else
                {
                    mymap.put(i,1);
                    
                    if(mymap.containsKey(i-1))
                    {
                        mymap.put(i,mymap.get(i-1)+1);
                        low=i-mymap.get(i)+1;
                        mymap.put(low,mymap.get(i-1)+1);
                    }
                    
                    if(mymap.containsKey(i+1))
                    {
                        high=i+mymap.get(i+1);
                        mymap.put(high, mymap.get(i+1)+mymap.get(i));
                        low=high-mymap.get(high)+1;
                        mymap.put(low,mymap.get(high));
                    }
                    
                }
        }
         int max=0;
        for(int i: mymap.values())
        {
            max=Math.max(max,i);
        }
        
        return max;
    }
}