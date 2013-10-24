public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pid = 0, firstmatch = 0;
        boolean[] dp = new boolean[s.length()+1];
        
		//only necessary for the big data test.
        int count = 0;
        for (Character c : p.toCharArray()) {
            if (c != '*')  ++count;
        }
        if (count > s.length())  return false;
        
        dp[0] = true;
        while(pid < p.length()){
            if(pid>0 && p.charAt(pid)=='*' && p.charAt(pid-1)=='*'){
                pid++;
                continue;
            }
            
            if(p.charAt(pid) == '*')
                for(int i=firstmatch; i<=s.length(); i++)
                    dp[i] = true;
            else{
                int match = -1;
                for(int i=s.length(); i>firstmatch; i--){
                    dp[i] = dp[i-1] && (p.charAt(pid) == '?' || p.charAt(pid) == s.charAt(i-1));
                    if(dp[i]) match = i;
                }
                if(match < 0) return false;
                firstmatch = match;
            }
            pid++;
        }
        
        return dp[s.length()];
    }
}


//下面这一段是摘抄的原文，可以说，这道题是leetcode上最为复杂的一题了
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)  return false;
    
        // calculate count for non-wildcard char
        int count = 0;
        for (Character c : p.toCharArray()) {
            if (c != '*')  ++count;
        }
        // the count should not be larger than that of s
        if (count > s.length())  return false;
    
        boolean[] matches = new boolean[s.length()+1];
        matches[0] = true;
        int pid = 0, firstMatch = 0;
        while (pid < p.length()) {
            // skip duplicate '*'
            if (pid > 0 && p.charAt(pid) == '*' && p.charAt(pid-1) == '*') {
                ++pid;
                continue;
            }
    
            // if '*', fill up the rest of row
            if (p.charAt(pid) == '*') {
                // fill up the rest of row with true, up to the first match in previous row
                for (int i = firstMatch+1; i <= s.length(); ++i)  matches[i] = true;
            } else {
                // fill up backwards:
                // - set to true if match current char and previous diagnal also match
                // - otherwise, set to false
                int match = -1;
                for (int i=s.length(); i>firstMatch; --i) {
                    matches[i] = (p.charAt(pid) == s.charAt(i-1) || p.charAt(pid) == '?') && matches[i-1];
                    if (matches[i])  match = i;
                }
                if (match < 0)  return false;
                firstMatch = match;
            }
    
            ++pid;
        }
    
        return matches[s.length()];
    }
}