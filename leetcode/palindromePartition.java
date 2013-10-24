public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> level = new ArrayList<String>();
        boolean[][] matrix = createDP(s);
        dfs(res, level, matrix, s, 0);
        return res;
    }
    private void dfs(ArrayList<ArrayList<String>> res, ArrayList<String> level, boolean[][] matrix, String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(level));
            return;
        }
        for(int i=pos; i<s.length(); i++){
            if(matrix[pos][i]){
                level.add(s.substring(pos, i+1));
                dfs(res, level, matrix, s, i+1);
                level.remove(level.size()-1);
            }
        }
    }
    private boolean[][] createDP(String s){
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        for(int i=0; i<len; i++) matrix[i][i] = true;
        for(int i=0; i<len; i++){
            int r = i, c = i+1;
            while(r>=0 && r<len && c>=0 && c<len && s.charAt(r)==s.charAt(c)){
                matrix[r][c] = true;
                r--;
                c++;
            }
            r = i-1;
            c = i+1;
             while(r>=0 && r<len && c>=0 && c<len && s.charAt(r)==s.charAt(c)){
                matrix[r][c] = true;
                r--;
                c++;
            }
        }
        return matrix;
    }
}





public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        boolean mem[][] = new boolean[s.length()][s.length()];
        
        for(int i=0; i<s.length(); i++){
            mem[i][i] = true;
        }
        
		// mem[][] start from (i, i), stores the possible palindrome starts at i
        for(int i=s.length()-2; i>=0; i--){
            mem[i][i+1] = (s.charAt(i+1) == s.charAt(i));
            for(int j=i+2; j<s.length(); j++){
                mem[i][j] = (s.charAt(i) == s.charAt(j)) && mem[i+1][j-1];
            }
        }
        
        res = palinImp(s, mem, 0);
        return res;
    }
    
    private ArrayList<ArrayList<String>> palinImp(String s, boolean[][] mem, int start){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(start == s.length()){
            res.add(new ArrayList<String>());
            return res;
        }
        
		// bottom-up backtracking, except the (i, i)==true, 
		// once there is another "true" in the mem[][],
		// a new ArrayList<String> is created (above is the code) to contain the new series of palindrome
        for(int i=start; i<s.length(); i++){
            if(mem[start][i]){
                for(ArrayList<String> tmp:palinImp(s, mem, i+1)){
                    tmp.add(0, s.substring(start, i+1));
                    res.add(tmp);
                }
            }
        }
        
        return res;
    }
}