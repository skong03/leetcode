public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<String>();
        dfs(res, sb, hs, n);
        return res;
    }
    private void dfs(ArrayList<String> res, StringBuilder sb, HashSet<String> hs, int n){
        if(sb.length() == n*2){
            res.add(sb.toString());
            return;
        }
        sb.insert(0, '(');
        for(int i=1; i<=sb.length(); i++){
            sb.insert(i, ')');
            if(!hs.contains(sb.toString())){
                hs.add(sb.toString());
                dfs(res, new StringBuilder(sb), hs, n);
            }
            sb.deleteCharAt(i);
        }
    }
}






public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        HashSet<String> hs = new HashSet<String>();
        dfs(res, hs, new StringBuilder(), n);
        return res;
    }
    private void dfs(ArrayList<String> res, HashSet<String> hs, StringBuilder sb, int n){
        if(sb.length() == 2*n){
            res.add(new String(sb));
            return;
        }
        sb.insert(0, '(');
        int len = sb.length();
        for(int i=1; i<=len; i++){
            sb.insert(i, ')');
            if(!hs.contains(sb.toString())){
                hs.add(sb.toString());
                dfs(res, hs, new StringBuilder(sb), n);
            }
            sb.deleteCharAt(i);
        }
    }
}

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<String>();
        if(n == 0) return res;
        parenImp(res, sb, set, 2*n);
        return res;
    }
    private void parenImp(ArrayList<String> res, StringBuilder sb, HashSet<String> set, int n){
        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }
        sb.insert(0, '(');
        int len = sb.length();
        for(int i=1; i<=len; i++){
            sb.insert(i, ')');
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                parenImp(res, new StringBuilder(sb), set, n);
            } 
            sb.deleteCharAt(i);
        }
    }
}


public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        char[] ch = new char[n*2];
        
        parenImp(res, ch, n, n, 0);
        
        return res;
    }
    
    private void parenImp(ArrayList<String> res, char[] ch, int left, int right, int cnt){
        if(left < 0 || left > right)
            return;
        if(left == 0 && right == 0){
            String str = String.copyValueOf(ch);
            res.add(str);
        }
        else{
            if(left > 0){
                ch[cnt] = '(';
                parenImp(res, ch, left-1, right, cnt+1);
            }
            if(right > left){
                ch[cnt] = ')';
                parenImp(res, ch, left, right-1, cnt+1);
            }
        }
    }
}