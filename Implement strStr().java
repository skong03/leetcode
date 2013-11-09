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

public class Solution {
    public String strStr(String haystack, String needle) {
       if(needle.length()==0)
       return haystack;
       if(haystack.length()<needle.length())
        return null;
        
        int diff= haystack.length()-needle.length()+1;
        
        for(int i=0; i< diff; i++)
        {
            if(haystack.substring(i).startsWith(needle))
            {
                return haystack.substring(i);
            }
        }
        return null;
    }
}

public class Solution {
    public String strStr(String haystack, String needle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int nlength=needle.length();
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,i+nlength).equals(needle))
                return haystack.substring(i);
        }
        return null;
    }
}

