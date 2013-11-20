public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuffer sb=new StringBuffer();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        
        int left=0;
        int right=sb.length()-1;
        while(left<right){
            if(sb.charAt(left)!=sb.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}