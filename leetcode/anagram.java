public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
        ArrayList<String> res = new ArrayList<String>();
        for(String str : strs){
            String tmpKey = toKey(str);
            if(!hm.containsKey(tmpKey)){
                LinkedList<String> vList = new LinkedList<String>();
                vList.add(str);
                hm.put(tmpKey, vList);
            } 
            else hm.get(tmpKey).add(str);
        }
        for(String key : hm.keySet()){
            if(hm.get(key).size() > 1)
                for(String str : hm.get(key))
                    res.add(str);
        }
        return res;
    }
    private String toKey(String str){
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}




public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
        
        for(String str : strs){
            String key = turnToKey(str);
            if(!hash.containsKey(key))
                hash.put(key, new LinkedList<String>());
            LinkedList<String> value = hash.get(key);
            value.add(str);
        }
        
        for(String key : hash.keySet()){
            LinkedList<String> value = hash.get(key);
            if(value.size() > 1)
                for(String str : value)
                    res.add(str);
        }
        
        return res;
    }
    
    private String turnToKey(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}