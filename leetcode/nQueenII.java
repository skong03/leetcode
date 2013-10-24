public class Solution {
    int res;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = 0;
        int[] board = new int[n];
        for(int i=0; i<n; i++) board[i] = -1;
        dfs(board, 0, n);
        return res;
    }
    private void dfs(int[] board, int pos, int n){
        if(pos == n){
            res++;
            return;
        }
        for(int i=0; i<n; i++){
            board[pos] = i;
            if(checkBoard(board, pos, i)) dfs(board, pos+1, n);
        }
    }
    private boolean checkBoard(int[] board, int r, int c){
        for(int i=0; i<r; i++)
            if(board[i] == board[r]) return false;
        for(int i=1; i<=r; i++)
            if(board[r-i]==c-i || board[r-i]==c+i) return false;
        return true;
    }
}



//DFSËã·¨
public class Solution {
    int res;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = 0;
        int[] board = new int[n];
        for(int i=0; i<n; i++) board[i] = -1;
        dfs(board, 0, n);
        return res;
    }
    private void dfs(int[] board, int row, int n){
        if(row == n){
            res++;
            return;
        }
        for(int i=0; i<n; i++){
            board[row] = i;
            if(isValid(board, row))
                dfs(board, row+1, n);
        }
    }
    private boolean isValid(int[] board, int row){
        for(int i=0; i<row; i++){
            if(board[i] == board[row] || board[i]+i == board[row]+row || board[i]-i == board[row]-row)
                return false;
        }
        return true;
    }
}




//¡°Î´ÃüÃû¡±Ëã·¨
public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        
        queenImp(0, queens, res);
        
        return res.size();
    }
    
    private void queenImp(int i, int[] queens, ArrayList<Integer> res){
        int n = queens.length;
        if(i == n){
            res.add(1);
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