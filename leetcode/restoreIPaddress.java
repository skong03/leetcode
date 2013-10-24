public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        String level = "";
        dfs(res, level, 0, 0, s);
        return res;
    }
    private void dfs(ArrayList<String> res, String level, int pos, int cnt, String s){
        if(cnt==4 && pos==s.length()){
            res.add(level.substring(1));
            return;
        }
        if(cnt < 4){
            for(int i=1; i<=3; i++){
                if(pos+i <= s.length()){
                    String piece = s.substring(pos, pos+i);
                    if(check(piece)){
                        String tmp = level + "." + piece;
                        dfs(res, tmp, pos+i, cnt+1, s);
                    }
                }
            }
        }
    }
    private boolean check(String str){
        int num = Integer.parseInt(str);
        if(str.length()>1 && num==0) return false;
        else if(str.charAt(0)=='0' && num>0) return false;
        else if(num>=0 && num<=255) return true;
        else return false;
    }
}





public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> level = new ArrayList<String>();
        if(s.length()<4 || s.length()>12) return res;
        dfs(res, level, s, 0);
        return res;
    }
    private void dfs(ArrayList<String> res, ArrayList<String> level, String s, int pos){
        if(pos == s.length()){
            if(level.size() == 4) loadIn(res, level);
            return;
        }
        for(int i=1; i<=3; i++){
            if(pos+i <= s.length()){
                String tmp = s.substring(pos, pos+i);
                if(isValid(tmp)){
                    level.add(tmp);
                    dfs(res, level, s, pos+i);
                    level.remove(level.size()-1);
                }
                else return;
            }
            else return;
        }
    }
    private void loadIn(ArrayList<String> res, ArrayList<String> level){
        String str = level.get(0)+"."+level.get(1)+"."+level.get(2)+"."+level.get(3);
        res.add(str);
    }
    private boolean isValid(String str){
        if(str.length()>1 && str.charAt(0)=='0') return false;
        int num = Integer.parseInt(str);
        if(num>=0 && num<=255) return true;
        else return false;
    }
}



public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        String tmp = "";
       
        if(s.length() > 12)
            return res;
       
        recImp(res, tmp, s, 0);
       
        return res;
    }
   
    private void recImp(ArrayList<String> res, String tmp, String s, int pos){
        if(tmp.length() == s.length() + 4 && pos == s.length()){
            if(tmp.charAt(tmp.length()-1) == '.'){
                tmp = tmp.substring(0, tmp.length()-1);
                res.add(new String(tmp));
            }
            return;
        }
        for(int i=pos; i<s.length(); i++){
            int n = getNum(s.substring(pos, i+1));
            if(n != -1){
                recImp(res, tmp+n+".", s, i+1);
            }
            else
                break;
        }
    }
   
    private int getNum(String str){
        int n = Integer.parseInt(str);
        if(str.charAt(0) == '0' && n > 0)
            return -1;
        if(str.length() > 1 && n == 0)
            return -1;
        if(n > 255)
            return -1;
        return n;
    }
}