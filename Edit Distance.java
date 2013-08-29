public class Solution {
    HashMap<String, Integer> mymap;
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mymap=new HashMap<String, Integer>();
        
        return helper(word1,0,word2,0);
    }
    
    public int helper(String word1,int i,String word2,int j)
    {
        String key=Integer.toString(i)+","+Integer.toString(j);
        
        if(mymap.containsKey(key))
            return mymap.get(key);
        
        int di=0;
        if(word1.length()==i && j<word2.length())
            di=word2.length()-j;
        else if(word2.length()==j && i<word1.length())
            di=word1.length()-i;
        else if(i<word1.length()&&j<word2.length())
            {
                if(word1.charAt(i)==word2.charAt(j))
                    di=helper(word1,i+1,word2,j+1);
                else 
                {
                    int insert=helper(word1,i+1,word2,j)+1;
                    int del=helper(word1,i,word2,j+1)+1;
                    int replace=helper(word1,i+1,word2,j+1)+1;
                    di=Math.min(insert,Math.min(del,replace));
                }
            }
        
        mymap.put(key,di);
        return di;
    }
}