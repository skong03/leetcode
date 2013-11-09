public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0)
            return false;
        int div=1;
        while(x/div>=10)
        {
            div=div*10;
        }
        
        while(x!=0)
        {
            int l=x/div;
            int r=x%10;
            if(l==r)
            {
                x=(x%div)/10;
                div=div/100;
            }
            else
                return false;
        }
        return true;
    }
}

public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //1.consider the negtive number
        //2.not allowed to use extra space, not allowed to use String, StringBuffer.
        if(x<0)
            return false;
        int div=1;
        
        while(div*10<=x){
            div=div*10;
        }
        
        while(x>0){
            int left=x/div;
            int right=x%10;
            if(left==right){
                x=(x%div)/10;
                div=div/100;
            }
            else
                return false;
        }
        return true;
    }
}

public class Solution {
    public boolean isPalindrome(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(x<0)
            return false;
        if(x>=0&&x<=9)
            return true;
        int div=1;
        
        while(x/div>=10){
            div*=10;
        }
        
        int l=x/div;
        int r=x%10;
        if(l==r){
            return isPalindrome(x%div/10);
        }else
            return false;
    }
}