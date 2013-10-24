public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean flag = x>0 ? true : false;
        x = Math.abs(x);
        int res = 0;
        while(x > 0){
            res = res*10 + x%10;
            x = x/10;
        }
        
        return flag ? res : res*(-1);
    }
}