public class Solution {
    public String multiply(String num1, String num2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int[] num=new int[num1.length()+num2.length()];
        for(int i=num2.length()-1;i>=0;i--){
            for(int j=num1.length()-1;j>=0;j--){
                num[i+j+1]+=(num2.charAt(i)-'0')*(num1.charAt(j)-'0');
            }
        }
        int cur=0;
        int car=0;
        for(int i =num.length-1;i>=0;i--){
            cur=num[i]+car;
            car=cur/10;
            cur=cur%10;
            num[i]=cur;
        }
        
        StringBuffer sb=new StringBuffer();//use the StringBuffer here, if the first is 0, not add
        if(num[0]!=0)
            sb.append(num[0]);
        for(int i=1;i<num.length;i++){
            sb.append(num[i]);
        }
        return sb.toString();
    }
}