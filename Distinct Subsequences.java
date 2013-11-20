public class Solution {
    HashMap<String,Integer> table;
    public int numDistinct(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        table=new HashMap<String, Integer>();
        return re(S,0,T,0);
    }
    public int re(String S, int i1, String T, int i2){
        String key=i1+","+i2;
        if(table.containsKey(key))
            return table.get(key);
        int num=0;
        if(i2==T.length())
            num= 1;
        else if(i1==S.length()&&i2!=T.length())
            num= 0;       
        else if(S.charAt(i1)!=T.charAt(i2))
            num=re(S,i1+1,T,i2);
        else
            num=re(S,i1+1,T,i2)+re(S,i1+1,T,i2+1);
        
        table.put(key,num);
        return num;
    }
}