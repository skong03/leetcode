public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] table=new boolean[s.length()][s.length()];
        int low=0;
        int maxlength=1;
        for(int i=0;i<s.length();i++)
        {
            table[i][i]=true;
        }
        
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                table[i-1][i]=true;
                low=i-1;
                maxlength=2;
            }
        }
        
        for(int len=3;len<=s.length();len++)
        {
            for(int i=0;i<=s.length()-len;i++)
            {
                int j=len+i-1;
                if(s.charAt(i)==s.charAt(j)&&table[i+1][j-1])
                {
                    
                    table[i][j]=true;
                    if(j-i+1>maxlength)
                    {
                    	
                        low=i;
                        maxlength=j-i+1;
                        //System.out.println( maxlength);
                    }
                }
            }
        }
        
        return s.substring(low,low+maxlength);
    }
}