public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[][] matrix = {
            {},{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, 
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(res, digits, sb, 0, matrix);
        return res;
    }
    private void dfs(ArrayList<String> res, String s, StringBuilder sb, int pos, char[][] matrix){
        if(sb.length() == s.length()){
            res.add(new String(sb.toString()));
            return;
        }
        int num = s.charAt(pos)-'0'-1;
        for(int i=0; i<matrix[num].length; i++){
            sb.append(matrix[num][i]);
            dfs(res, s, sb, pos+1, matrix);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}


public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        String tmp = "";
        char[][] table = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, 
                            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        
        recImp(res, tmp, digits, table, 0);
        return res;
    }
    
    private void recImp(ArrayList<String> res, String tmp, String digits, char[][] table, int pos){
        if(tmp.length() == digits.length()){
            res.add(new String(tmp));
            return;
        }
        for(int i=pos; i<digits.length(); i++){
            int c = digits.charAt(i) - '0';
            for(int j=0; j<table[c-1].length; j++){
                recImp(res, tmp+table[c-1][j], digits, table, i+1);
            }
        }
    }
}