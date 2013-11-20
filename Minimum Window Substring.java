public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> hasfound=new HashMap<Character,Integer>();
        HashMap<Character, Integer> need=new HashMap<Character,Integer>();
        
        for(int i=0;i<T.length();i++)
        {
            char key=T.charAt(i);
            if(need.containsKey(key))
            {
                need.put(key,need.get(key)+1);
            }
            else
            {
                need.put(key,1);
                hasfound.put(key,0);
            }
        }
        
        int left=0;
        int count=0;
        int max=Integer.MAX_VALUE;
        String res="";
        ArrayList<Integer> pos=new ArrayList<Integer>();
        for(int right=0;right<S.length();right++)
        {
            char c=S.charAt(right);
            if(need.containsKey(c))
            {
                pos.add(right);
                hasfound.put(c,hasfound.get(c)+1);
                if(hasfound.get(c)<=need.get(c))
                    count++;
                  //System.out.println(pos);
                if(count==T.length())//find window
                {
             
                    char l=S.charAt(pos.get(left));
                    while(hasfound.get(l)-1>=need.get(l))
                    {
                        hasfound.put(l,hasfound.get(l)-1);
                        left++;
                        l=S.charAt(pos.get(left));
                    }
                    if(right-pos.get(left)<max)
                    {
                        max=right-pos.get(left);
                        res=S.substring(pos.get(left),right+1);
                        //System.out.println(res);
                    }
                }
            }
        }
        
        if(count<T.length())//watch out here
            return "";
        else
            return res;
        
        
    }
}