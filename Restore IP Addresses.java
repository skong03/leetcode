public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res=new ArrayList<String>();
        //if (s.length()<4||s.length()>12) return res;  
        dfs(s,"",0,res);
        return res;
    }
    
    public void dfs(String str, String temp, int count, ArrayList<String> res)
    {
        if(count==3 && isvalid(str))
        {
            res.add(temp+str);
            return;
        }
        
        for(int i=1;i<=3 && i<str.length();i++)
        {
            String s=str.substring(0,i);
            if(isvalid(s))
            {
                dfs(str.substring(i), temp+s+"." , count+1, res);
            }
        }
        
    }
    public boolean isvalid(String str)
    {
        if(str.charAt(0)=='0')
            return str.equals("0");
        else
            {
                int t=Integer.parseInt(str);
                return t<=255;
            }
    }
}