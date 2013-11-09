public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(strs.length<1)
            return "";
        
        Arrays.sort(strs);
        String longest=strs[0];
        int index=longest.length()-1;
        for(int i=1;i<strs.length;i++){
            String cur=strs[i];
            for(int j=0;j<=index;j++){
                if(cur.charAt(j)!=longest.charAt(j)){
                    index=j-1;
                }
            }
        }
        
        return longest.substring(0,index+1);
    }
}