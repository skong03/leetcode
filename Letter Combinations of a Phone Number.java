public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[][] table = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}}; 
        ArrayList<String> res=new ArrayList<String>();
        
        dfs(digits,res,"",table);
        return res;
    
    }
    
    public void dfs(String digits,ArrayList<String> res, String temp,char[][] table)
    {
        if(digits.length()==0)
            {res.add(temp);return;}
        for(int i=0;i<table[digits.charAt(0)-'0'].length;i++)
        {
            dfs(digits.substring(1), res, temp+table[digits.charAt(0)-'0'][i],table);
        }
    
    }
}