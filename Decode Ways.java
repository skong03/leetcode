public class Solution {
    public int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.length()==0)
            return 0;
        int[] res=new int[s.length()+1];
        res[0]=1;
        if(isvalid(s.substring(0,1)))   
            res[1]=1;
        else
            res[1]=0;
            
        for(int i=2;i<=s.length();i++){
            if(isvalid(s.substring(i-1,i)))
                res[i]=res[i-1];
            if(isvalid(s.substring(i-2,i)))
                res[i]+=res[i-2];
        }
        return res[s.length()];
        
    }
    public boolean isvalid(String s){
        if(s.charAt(0)=='0')
            return false;
        int i=Integer.parseInt(s);
        return i>0&&i<=26;
    }
}

public class Solution {
    public int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.length()==0)
            return 0;
        int[] dp=new int[s.length()+1];//add two previse two item
        dp[0]=1;
        if(valid(s.substring(0,1)))
            dp[1]=1;
        for(int i=1;i<s.length();i++){
            if(valid(s.substring(i,i+1)))
                dp[i+1]=dp[i];
            if(valid(s.substring(i-1,i+1)))
                dp[i+1]+=dp[i-1];
        }
        return dp[s.length()];
    }
    
    public boolean valid(String s){
        if(s.charAt(0)=='0')
            return false;
        else{
            int temp=Integer.parseInt(s);
            return temp>=1&&temp<=26;
        }
    }
}