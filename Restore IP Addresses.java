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

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
           ArrayList<String> res=new ArrayList<String>();
           if (s.length()<4||s.length()>12) return res;  
           dfs(res, "", 0, s);
           return res;
    }
    public void dfs(ArrayList<String> res, String temp, int dot, String number){
        if(dot==3){
            if(valid(number)){
                temp+=number;
                res.add(temp);
            }
            return;
        }
        
        for(int i=1;i<=3&&i<number.length();i++){
            String n=number.substring(0,i);
            if(valid(n)){
                //temp=temp+n+".";// here will make mistake, I don't understand
                dfs(res, temp+n+".", dot+1, number.substring(i));
            }
        }
    }
    public boolean valid(String s){
        if(s.charAt(0)=='0')
            return s.equals("0");
        else{
            int n=Integer.parseInt(s);
            return n>0&&n<=255;
        }
    }
}