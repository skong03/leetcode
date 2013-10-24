public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : L){
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else
                map.put(s, 1);
        }
        
        int len = L[0].length();
        for(int i=0; i<=S.length()-len*L.length; i++){
            HashMap<String, Integer> words = new HashMap<String, Integer>(map);
            int index = i;
            while(true){
                String sub = S.substring(index, index+len);
                if(words.containsKey(sub)){
                    if(words.get(sub) == 1)
                        words.remove(sub);
                    else
                        words.put(sub, words.get(sub)-1);
                    if(words.isEmpty()){
                        res.add(i);
                        break;
                    }
                    index += len;
                }
                else
                    break;
            }
        }
        
        return res;
    }
}