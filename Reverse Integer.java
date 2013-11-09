public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(x==0)
        return 0;
        
        StringBuffer sb= new StringBuffer();
        if(x<0)
            sb.append("-");
        
        x=Math.abs(x);
        while(x>0)
        {
            sb.append(x%10);
            x=x/10;
        }
        
        return Integer.parseInt(sb.toString());
    }
}

public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean sign=true;
        if(x<0){
            sign=false;
            x=Math.abs(x);
        }
        
        long number=0;
        
        while(x>0){
            number=number*10+x%10;
            x=x/10;
        }
        
        if(sign){
            if(number>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int)number;
        }else{
            number=0-number;
            if(number<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int)number;
        }
    }
}