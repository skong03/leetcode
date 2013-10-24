public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] b=table(s);
        int[] cut=new int[s.length()+1];
        cut[s.length()]=0;
        for(int i=s.length()-1;i>=0;i--){
            cut[i]=s.length()-i;
            for(int r=i;r<s.length();r++){
                if(b[i][r])
                    cut[i]=Math.min(cut[r+1]+1,cut[i]);
            }
        }
        
        return cut[0]-1;
    }
    
    public boolean[][] table(String s){
        boolean[][] b=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            b[i][i]=true;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i))
                b[i-1][i]=true;
        }
        for(int len=3;len<=s.length();len++){
            for(int l=0;l+len<=s.length();l++){
                int r=l+len-1;
                if(b[l+1][r-1]&&s.charAt(l)==s.charAt(r))
                    b[l][r]=true;
            }
        }
        return b;
    }
}