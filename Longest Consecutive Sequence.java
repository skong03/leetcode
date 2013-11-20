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

public class Solution {
    public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<Integer, Integer> table=new HashMap<Integer,Integer>();
        int max=0;
        for(int i:num){
            if(!table.containsKey(i)){
                int newlen=1;
                if(table.containsKey(i-1)&&table.containsKey(i+1)){
                    newlen=1+table.get(i-1)+table.get(i+1);
                    int Leftkey=i-table.get(i-1);
                    int Rightkey=i+table.get(i+1);
                    table.put(Leftkey,newlen);
                    table.put(Rightkey,newlen);
                    table.put(i,1);
                }else if(table.containsKey(i-1)){
                    newlen=1+table.get(i-1);
                    int Leftkey=i-table.get(i-1);
                    table.put(Leftkey,newlen);
                    table.put(i,newlen);
                }else if(table.containsKey(i+1)){
                    newlen=1+table.get(i+1);
                    int Rightkey=i+table.get(i+1);
                    table.put(Rightkey,newlen);
                    table.put(i,newlen);
                }else{
                    table.put(i,newlen);
                }
                if(newlen>max){
                    max=newlen;
                }
            }
        }
        return max;
    }
}