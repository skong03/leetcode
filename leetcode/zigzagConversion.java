public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows == 1) return s;
        int div = (nRows-1) * 2;
        StringBuilder sb = new StringBuilder();
        for(int mod=0; mod<nRows; mod++){
            for(int i=0; i<s.length(); i++){
                int x = i % div;
                if(x%div==mod || (x%div>=nRows && div%x==mod))
                    sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}







public class Solution {  
    public String convert(String s, int nRows) {  
        // Start typing your Java solution below  
        // DO NOT write main() function          
        if(s==null) return null;  
        int sz = s.length();  
          
        if(nRows<=1) return s;  
        //int i=0;  
          
        StringBuilder sb = new StringBuilder();  
          
        for(int i=0; i<nRows; i++) {  
            int j=i;  
            while(j<sz) {  
                sb.append( s.charAt(j) );
                if( (i% (nRows-1)) != 0) {  
                    int k = j + (nRows-1-i)*2;         //define new int k and save the old value in j for next loop  
                    if(k<sz) sb.append(s.charAt(k) );  //must check k<sz; may be exceed string length.  
                }  
                j+=2*(nRows-1);  
            }  
        }   
        return sb.toString();  
    }  
}  