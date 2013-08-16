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
                continue;
            }
            
            if(mychar[i]=='-' && fuhao)
            {
                fuhao=false;
                pos=false;
                space=false;
                continue;
            }
            
            if(mychar[i]>='0' && mychar[i]<='9')
            {
                space=false;
                fuhao=false;
                sum=sum*10+(mychar[i]-'0');
                continue;
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