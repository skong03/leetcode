public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=haystack.length();
        int n=needle.length();
        if(haystack.length()<needle.length())
            return null;
        if(needle.length()==0)
            return haystack;
        for(int i=0; i< m-n+1;i++)
        {
            int in=i;
            int j=0;
            while(j<n && in<m&&haystack.charAt(in)==needle.charAt(j) )
            {   
                in++;
                j++;
            }
            if(j==n)
                return haystack.substring(i);
        }
        return null;
    }
}