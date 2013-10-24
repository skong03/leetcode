public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++)
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))
                sb.append(s.charAt(i));
        int left = 0, right = sb.length()-1;
        while(left < right)
            if(sb.charAt(left++) != sb.charAt(right--)) return false;
        
        return true;
    }
}



public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        // the method: toLowerCase() is the key method in this alg.
		s = s.toLowerCase();
        
        for(int i=0; i<s.length(); i++){
            if((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57))
                sb.append(s.charAt(i));
        }
        
        s = sb.toString();
        
        return palinImp(s);
    }
    
    private boolean palinImp(String s){
        if(s.length() <= 1)
            return true;
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}