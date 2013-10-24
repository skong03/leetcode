public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle.length()==0) return haystack;
        int[] overLay = getOverLay(needle);
        int i=0, j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else if(j==0) i++;
            else j = overLay[j-1]+1;
            if(j==needle.length()) return haystack.substring(i-j);
        }
        return null;
    }
    private int[] getOverLay(String needle){
        char[] pat = needle.toCharArray();
        int[] overLay = new int[pat.length];
        overLay[0] = -1;
        int index = 0;
        for(int i=1; i<pat.length; i++){
            index = overLay[i-1];
            while(index>=0 && pat[index+1]!=pat[i]) index = overLay[index];
            if(pat[i] == pat[index+1]) overLay[i] = index+1;
            else overLay[i] = -1;
        }
        return overLay;
    }
}

public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] jungle = haystack.toCharArray();
        char[] wood = needle.toCharArray();
        
        if(wood.length == 0)
            return haystack;
        if(wood.length > jungle.length)
            return null;
        
        boolean flag = false;
        for(int i=0; i<jungle.length; i++){
            if(wood[0] == jungle[i] && (i + wood.length) <= jungle.length){
                String tmp = haystack.substring(i, i+wood.length);
                if(tmp.equals(needle))
                    return haystack.substring(i);
            }
            else
                continue;
        }
        
        return null;
    }
}