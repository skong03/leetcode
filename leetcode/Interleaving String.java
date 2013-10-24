public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1,0,s2,0,s3,0);
    }
    
    public boolean dfs(String s1, int pos1, String s2, int pos2, String s3, int pos3){
        if (pos3==s3.length()) return true;
        if (pos1==s1.length()) return s2.substring(pos2).equals(s3.substring(pos3));
        if (pos2==s2.length()) return s1.substring(pos1).equals(s3.substring(pos3));
        char c1 = s1.charAt(pos1);
        char c2 = s2.charAt(pos2);
        char c3 = s3.charAt(pos3);
        if(c1==c3 && c2==c3) 
            return dfs(s1,pos1+1,s2,pos2,s3,pos3+1) || dfs(s1,pos1,s2,pos2+1,s3,pos3+1);
        else if (c1==c3)
            return dfs(s1,pos1+1,s2,pos2,s3,pos3+1);
        else if (c2==c3)
            return dfs(s1,pos1,s2,pos2+1,s3,pos3+1);
        else
            return false;
    }
}