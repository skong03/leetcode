public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        int tmp = 0;
        boolean[] map;
        
        for(int i=0; i<s.length(); i++){
            map = new boolean[256];
            tmp = 0;
            for(int j=i; j<s.length(); j++){
                if(map[(int)s.charAt(j)] == false){
                    tmp++;
                    map[(int)s.charAt(j)] = true;
                    res = Math.max(res, tmp);
                }
                else{
                    break;
                }
            }
        }
        
        return res;
    }
}