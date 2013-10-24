public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        boolean sign = str.charAt(0)=='-'?false:true;
        if(str.charAt(0)=='+' || str.charAt(0)=='-') str = str.substring(1);
        int i = 0;
        long res = 0;
        while(i<str.length()){
            if(str.charAt(i)>='0' && str.charAt(i)<='9') res = 10*res + (str.charAt(i)-'0');
            else break;
            i++;
        }
        
        if(res > Integer.MAX_VALUE) return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return sign?(int)res:-(int)res;
    }
}


public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str.length() == 0)
            return 0;
        str = str.trim();
        int index = 0;
        boolean flag = true;
        char c = str.charAt(0);
        if(c < '0' || c > '9'){
            if(c == '-')
                flag = false;
            else if(c == '+')
                flag = true;
            else
                return 0;
            index++;
        }
       
        long res = 0;
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            res = res*10 + str.charAt(index) - '0';
           
            if(res > Integer.MAX_VALUE)
                return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
           
            index++;
        }
       
        return flag?(int)res:(int)res*(-1);
    }
}