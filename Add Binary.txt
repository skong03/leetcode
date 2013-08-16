public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuffer sum=new StringBuffer("");
        
        int max=Math.max(a.length(), b.length());
        int carry=0;
        int cur=0;
        for(int i=0; i<max ; i++)
        {
            int a1=getbit(a,i);
            int b1=getbit(b,i);
            cur=(a1+b1+carry)%2;
            carry=(a1+b1+carry)/2;
            
            //System.out.println(a1+"    "+b1  +"   carry:" +carry);
            sum.append(cur);
        }
        if(carry==1)
        {sum.append(carry);}
        
        return sum.reverse().toString();
    }
    
    public int getbit(String s, int i)
    {
        if(i>=s.length())
        {return 0;}
        if(s.charAt(s.length()-i-1)=='1')
            return 1;
        else
            return 0;
    }
}