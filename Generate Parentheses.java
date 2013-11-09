public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res= new ArrayList<String>();
        String s="";
        dfs(res, s, n,n);
        return res;
    }
    
    public void dfs(ArrayList<String> res, String s, int left, int right)
    {
        if(left>right || left<0)//left <0 forget
            return;
        
        if(left==0 && right==0)
        {
            res.add(s);
        }
        
        String s1=s+"(";
        String s2=s+")";
        dfs(res, s1, left-1, right);
        dfs(res, s2, left, right-1);
        
    }
}