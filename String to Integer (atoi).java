public class Solution {
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        //1.consider overflow,
        //2.consdier sign and space
        long res=0;
        boolean sign=false;
        boolean positive=true;
        boolean space=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '&&!space){
                continue;
            }
            else if(str.charAt(i)=='+'&&!sign){
                space=true;
                sign=true;
            }
            else if(str.charAt(i)=='-'&&!sign){
                space=true;
                sign=true;
                positive=false;
            }
            else if(str.charAt(i)-'0'>=0&&str.charAt(i)-'0'<=9){
                sign=true;
                space=true;
                res=res*10+(str.charAt(i)-'0');
            }
            else
                break;
        }
        
        if(positive){
            if(res>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int)res;
        }else
        {
            if(-res<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int)(-res);
        }
        
    }
}

public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] mychar= str.toCharArray();
        
        boolean space=true;
        boolean fuhao=true;
        boolean pos=true;
        
        long sum=0;
        
        for(int i=0; i< mychar.length; i++)
        {
            if(mychar[i]==' ' && space )
            {
                continue;
            }
            
            if(mychar[i]=='+' && fuhao)
            {
                fuhao=false;
                space=false;
                pos=true;
                //continue;
            }
            
            if(mychar[i]=='-' && fuhao)
            {
                fuhao=false;
                pos=false;
                space=false;
                //continue;
            }
            
            if(mychar[i]>='0' && mychar[i]<='9')
            {
                space=false;
                fuhao=false;
                sum=sum*10+(mychar[i]-'0');
                //continue;
            }
            
            else
            break;
            
        }
        
        if(pos)
        {
            if(sum>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
            int result=(int)sum;
            
            return result;
        }
        else
        {
            if(sum>Integer.MAX_VALUE)
            return Integer.MIN_VALUE;
            
            int result=-(int)sum;
            
            return result;
        }
    }
}