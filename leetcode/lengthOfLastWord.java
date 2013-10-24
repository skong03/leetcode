public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] ch = s.toCharArray();
        int res = 0;
        
        int index = ch.length-1;
        for(int i=ch.length-1; i>=0; i--){
            if(ch[i] != ' '){
                index = i;
                break;
            }
            if(i == 0)
                return 0;
        }
        
        String str = s.substring(0, index+1);
        ch = str.toCharArray();
        
        for(int i=ch.length-1; i>=0; i--){
            if(ch[i] == ' '){
                res = ch.length - 1 -i;
                break;
            }
        }
        
        if(ch.length > 0 && res == 0)
            return ch.length;
        
        return res;
    }
}