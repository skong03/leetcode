public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] dp = new String[n];
        dp[0] = "1";
        for(int i=1; i<n; i++){
            String tmp = dp[i-1];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<tmp.length(); j++){
                int cnt = 1;
                char val = tmp.charAt(j);
                while(j+1 < tmp.length() && tmp.charAt(j+1) == tmp.charAt(j)){
                    cnt++;
                    j++;
                }
                sb.append(cnt);
                sb.append(val);
            }
            dp[i] = sb.toString();
        }
        return dp[n-1];
    }
}


1 11 21 1211 111221 312211 13112221 

public class Solution{
	public String countAndSay(int n){
		String cur="1";
		for(int i=1;i<n;i++){
			StringBuffer next=new StringBuffer();
			for(int j=0;j<cur.length();j++){
				int cnt=1;
				char val=cur.charAt(j);
				while(j+1<cur.length()&&cur.charAt(j+1)==cur.charAt(j)){
					cnt++;
					j++;
				}
				next.append(cnt);
				next.append(cur.charAt(j));
			}
			cur=next.toString();
		}
		return cur;
	}
}


public class Solution {
    public String countAndSay(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String cur="1";
        
        int count=1;
        for(int i=0;i<n-1;i++){
        	StringBuffer next=new StringBuffer();//need to clear the buffer
            for(int j=0;j<cur.length();j++){
                if(j+1>=cur.length()||cur.charAt(j)!=cur.charAt(j+1)){
                    next.append(count);
                    next.append(cur.charAt(j));
                    count=1;
                }else
                    count++;
            }
            cur=next.toString();
            
        }
        return cur;
    }
}