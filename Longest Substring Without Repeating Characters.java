public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashSet<Character> table=new HashSet<Character>();
        
        int max=0;
        int left=0,right=0;
        while(right<s.length()){
            char key=s.charAt(right);
            if(table.contains(key)){
                table.remove(s.charAt(left));
                left++;
            }else{
                table.add(key);
                if(table.size()>max){
                    max=table.size();
                }
                right++;
            }
        }
        return max;
    }
}