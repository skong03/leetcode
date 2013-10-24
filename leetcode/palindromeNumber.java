public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0)
            return false;
        
        int div = 10;
        while(x/div > 9)
            div *= 10;
        while(x > 9){
            int left = x/div;
            int right = x%10;
            if(left != right)
                return false;
            x = x % div /10;
            div /= 100;
        }
        
        return true;
    }
}