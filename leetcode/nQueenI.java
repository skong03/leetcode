public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] board = new int[n];
        for(int i=0; i<board.length; i++) board[i] = -1;
        dfs(res, board, 0, n);
        return res;
    }
    private void dfs(ArrayList<String[]> res, int[] board, int pos, int n){
        if(pos == n){
            res.add(drawBoard(board));
            return;
        }
        for(int i=0; i<n; i++){
            if(checkBoard(board, pos, i)){
                board[pos] = i;
                dfs(res, board, pos+1, n);
                board[pos] = -1;
            }
        }
    }
    private boolean checkBoard(int[] board, int r, int c){
        board[r] = c;
        for(int i=0; i<r; i++)
            if(board[i]==board[r]) return false;
        for(int i=1; i<=r; i++){
            if(board[r-i]==c-i) return false;
            if(board[r-i]==c+i) return false;
        }
        return true;
    }
    private String[] drawBoard(int[] board){
        String[] strs = new String[board.length];
        for(int i=0; i<board.length; i++){
            String str = new String();
            for(int j=0; j<board.length; j++){
                if(j != board[i]) str += ".";
                else str += "Q";
            }
            strs[i] = str;
        }
        return strs;
    }
}






//DFS算法
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] board = new int[n];
        for(int i=0; i<n; i++) board[i] = -1;
        
        dfs(res, board, 0, n);
        
        return res;
    }
    private void dfs(ArrayList<String[]> res, int[] board, int row, int n){
        if(row == n){
            draw(res, board, n);
            return;
        }
        
        for(int i=0; i<n; i++){
            board[row] = i;
            if(isValid(board, row)){
                dfs(res, board, row+1, n);
            }
        }
    }
    private boolean isValid(int[] board, int row){
        for(int i=0; i<row; i++){
            if(board[i] == board[row] || board[i]-i==board[row]-row || board[i]+i==board[row]+row)
                return false;
        }
        return true;
    }
    private void draw(ArrayList<String[]> res, int[] board, int n){
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            String s = new String();
            for(int j=0; j<n; j++){
                s += board[i]==j?"Q":".";
            }
            strs[i] = s;
        }
        res.add(strs);
    }
}







//另一种算法。
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        ArrayList<String[]> res = new ArrayList<String[]>();
        
        queenImp(0, queens, res);
        
        return res;
    }
    
    private void queenImp(int i, int[] queens, ArrayList<String[]> res){
        int n = queens.length;
        if(i == n){
            String[] str = new String[n];
            res.add(str);
            for(int a=0; a<n; a++){
                StringBuilder sb = new StringBuilder();
                for(int b=0; b<n; b++){
                    if(queens[a] == b)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                str[a] = sb.toString();
            }
            return;
        }
        
        for(int j=0; j<n; j++){
            if(checkPos(i, j, queens)){
                queens[i] = j;
                queenImp(i+1, queens, res);
                queens[i] = -1;
            }
        }
    }
    
    private boolean checkPos(int i, int j, int[] queens){
        int n = queens.length;
        for(int k=0; k<i; k++){
            if(queens[k] == j)
                return false;
        }
        
        for(int k=0; k<=i && k<=j; k++){
            if(queens[i-k] == j-k)
                return false;
        }
        
        for(int k=0; k<n-j && k<=i; k++){
            if(queens[i-k] == j+k)
                return false;
        }
        
        return true;
    }
}