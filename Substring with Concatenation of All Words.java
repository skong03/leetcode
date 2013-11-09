public class Solution {
    public ArrayListInteger findSubstring(String S, String[] L) {
         Note The Solution object is instantiated only once and is reused by each test case.
        HashMapString ,Integer table=new HashMapString, Integer();
        for(String sL){
            if(table.containsKey(s))
                table.put(s,table.get(s)+1);
            else
                table.put(s,1);
        }
        int len=L[0].length();
        ArrayListInteger res=new ArrayListInteger();
        for(int i=0;i=S.length()-L.lengthlen;i++){
            if(table.containsKey(S.substring(i,i+len))){
                HashMapString, Integer temptable=new HashMapString, Integer(table);
                for(int j=0;jL.length;j++){
                    String key=S.substring(i+jlen,i+(j+1)len);
                    if(temptable.containsKey(key)){
                        if(temptable.get(key)==1)
                            temptable.remove(key);
                        else
                            temptable.put(key,temptable.get(key)-1);
                    }else
                        break;
                }
                if(temptable.isEmpty())
                    res.add(i);
            }
        }
        
        return res;
    }
}