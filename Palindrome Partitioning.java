public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
        ArrayList<String> temp=new ArrayList<String>();
        boolean[][] b=table(s);
        dfs(res,temp,0,s,b);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<String>> res,ArrayList<String> temp,int left,String s,boolean[][] table){
        if(left==s.length())
            {res.add(new ArrayList<String>(temp));return;}
        
        for(int right=left;right<s.length();right++){
                if(table[left][right])
                {
                    temp.add(s.substring(left,right+1));
                    dfs(res,temp,right+1,s,table);
                    temp.remove(temp.size()-1);
                }
        }
    }
    
    public boolean[][] table(String s){
        boolean[][] b=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            b[i][i]=true;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
            b[i-1][i]=true;
        }
        for(int len=3;len<=s.length();len++){
            for(int left=0;left+len<=s.length();left++){
                int right=len+left-1;
                if(b[left+1][right-1]&&s.charAt(left)==s.charAt(right))
                    b[left][right]=true;
            }
        }
        return b;
    }
}