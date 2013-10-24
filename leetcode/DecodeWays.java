//DP: WHAT'S THE ARRAY'S USE?
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=0, j=1; i<s.length(); i++, j++){
            if(s.charAt(i) == '0'){
                if(i>0 && (s.charAt(i-1)=='1' || s.charAt(i-1)=='2')) dp[j] = dp[j-2];
                else return 0;
            }
            else if(i>0 && (s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)>='1' && s.charAt(i)<='6')))
                dp[j] = dp[j-1] + dp[j-2];
            else dp[j] = dp[j-1];
        }
        return dp[s.length()];
    }
}

//RECURSION: BASE CASE + RECURSIVE
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return 0;
        return recImp(s);
    }
    private int recImp(String s){
        if(s.length()>0 && s.charAt(0)=='0') return 0;
        if(s.length()==0 || s.length()==1) return 1;
        char c1 = s.charAt(0), c2 = s.charAt(1);
        if((c1=='1' || c1=='2') && c2=='0') return recImp(s.substring(2));
        else if((c1=='1' && c2!='0') || (c1=='2' && c2>=1 && c2<='6'))
            return recImp(s.substring(1)) + recImp(s.substring(2));
        else return recImp(s.substring(1));
    }
}



//DP
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0)
            return 0;
        
        int[] mem = new int[s.length()+1];
        mem[0] = 1;
        
        for(int i=0, j=1; i<s.length(); i++, j++){
            if(s.charAt(i) == '0'){
                if(i > 0 && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
                    mem[j] = mem[j-2];
                else
                    return 0;
            }
            else if(i > 0 && ((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')))
                mem[j] = mem[j-1] + mem[j-2];
            else
                mem[j] = mem[j-1];
        }
        
        return mem[s.length()];
    }
}


//Recursion
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() < 1)
            return 0;
        
        return numImp(s, 0);
    }
    
    private int numImp(String s, int pos){
        if(pos == s.length())
            return 1;
        int sum = 0;
        int one = Integer.parseInt(s.substring(pos, pos+1));
        int two = (pos+1 < s.length()) ? Integer.parseInt(s.substring(pos, pos+2)) : -1 ;
        
        if(one == 0)
            sum = 0;
        else if(two == 10)
            sum = numImp(s, pos+2);
        else if(two > 10 && two <= 26)
            sum = numImp(s, pos+1) + numImp(s, pos+2);
        else
            sum = numImp(s, pos+1);
        
        return sum;
    }
}
