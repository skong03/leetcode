public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashMap<String, ArrayList<String>> amap= new HashMap<String, ArrayList<String>>();
        ArrayList<String> res= new ArrayList<String>();
        for(String str: strs)
        {
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(amap.containsKey(key))
            {
                amap.get(key).add(str);
            }
            else
            {
                ArrayList<String> temp= new ArrayList<String>();
                temp.add(str);
                amap.put(key,temp);
            }
        }
        
        for(ArrayList<String> a: amap.values())
        {
            if(a.size()>1)//forget, just add the String which is dupilcate
                res.addAll(a);
        }
        
        return res;
    }
}