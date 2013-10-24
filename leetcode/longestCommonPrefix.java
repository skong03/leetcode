public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length < 1)
            return new String();
        if(strs.length == 1)
            return strs[0];
        
        for(int i=0; i<strs.length; i++){
            if(strs[i].length() < 1)
                return "";
        }
        
        Arrays.sort(strs);
        char[] ch = strs[0].toCharArray();
        int index = -1;
        
        for(int i=1; i<strs.length; i++){
            char[] tmp = strs[i].toCharArray();
            for(int j=0; j<ch.length; j++){
                if(ch[j] == tmp[j]){
                    index = j;
                }
                else
                    break;
            }
            if(index == -1)
                return "";
            String str = strs[i].substring(0, index+1);
            ch = str.toCharArray();
            index = -1;
        }
        
        return String.valueOf(ch);
    }
}