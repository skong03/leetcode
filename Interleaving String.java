public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
           if(s3.length()!==s1.length()+s2.length())
                return false;
            return isInterleave(s1,0,s2,0,s3,0);
    }
    public boolean isInterleave(String s1,int i1, String s2, int i2, String s3,int i3){
        if(i1==s1.length())
            return s2.substring(i2).equals(s3.substring(i3));
        if(i2==s2.length())
            return s1.substring(i1).equals(s3.substirng(i3));
            
        if(s1.charAt(i1)==s3.charAt(i3)&&s2.charAt(i2)==s3.charAt(i3)){
            if(isInterleanve(s1,i1+1,s2,i2,s3,i3+1)||isInterleanve(s1,i1,s2,i2+1,s3,i3+1))
                return true;
        }
        else if(s1.charAt(i1)==s3.charAt(i3)){
            if(isInterleanve(s1,i1+1,s2,i2,s3,i3+1))
                return true;
        }
        else {
            if(isInterleanve(s1,i1,s2,i2+1,s3,i3+1))
                return true;
        }
        
        return false;
    }
}

