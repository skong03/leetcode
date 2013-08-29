public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int m=num1.length();
        int n=num2.length();

        boolean f=true;
        int[] rl=new int[m+n];
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
                {
                    rl[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                }
        }
        
        int car=0;
        for(int i=m+n-1;i>=0;i--)
        {
            rl[i]+=car;
            car=rl[i]/10;
            rl[i]=rl[i]%10;
        }
        
        String res="";
        for(int i=0;i<rl.length;i++)
        {
            if(rl[0]==0&&f)
		    {f=false;}
		    else
		    {res=res+rl[i];}
        }        
        
        return res;
    }
}