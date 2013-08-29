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