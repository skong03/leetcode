//练习，注意dfs返回boolean，非常赞
public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dfs(board, 0);
    }
    private boolean dfs(char[][] board, int pos){
        int m = board.length, n = board[0].length;
        if(pos == m*n){
            return true;
        }
        int row = pos / n, col = pos % n;
        if(board[row][col] == '.'){
            for(char c='1'; c<='9'; c++){
                board[row][col] = c;
                if(check(board, row, col)){
                    if(dfs(board, pos+1)) return true;
                }
                board[row][col] = '.';
            }
        }
        else return dfs(board, pos+1);
        return false;
    }
    
    private boolean check(char[][] board, int row, int col){
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++)
            if(i!=row && board[i][col]==board[row][col]) return false;
        for(int j=0; j<n; j++)
            if(j!=col && board[row][j]==board[row][col]) return false;
        int r = row/3 * 3, c = col/3 * 3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(i!=row && j!=col && board[i][j]==board[row][col])
                    return false;
            }
        }
        return true;
    }
}


//练习,注意flag的全局变量初始化位置，很考究
public class Solution {
    boolean flag;
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        flag = false;
        dfs(board, 0);
    }
    private void dfs(char[][] board, int pos){
        int m = board.length, n = board[0].length;
        if(pos == m*n){
            flag = true;
            return;
        }
        int row = pos / n, col = pos % n;
        if(board[row][col] == '.'){
            for(char c='1'; c<='9'; c++){
                board[row][col] = c;
                if(check(board, row, col)){
                    dfs(board, pos+1);
                    if(flag) return;
                }
                board[row][col] = '.';
            }
        }
        else dfs(board, pos+1);        
    }
    
    private boolean check(char[][] board, int row, int col){
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++)
            if(i!=row && board[i][col]==board[row][col]) return false;
        for(int j=0; j<n; j++)
            if(j!=col && board[row][j]==board[row][col]) return false;
        int r = row/3 * 3, c = col/3 * 3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(i!=row && j!=col && board[i][j]==board[row][col])
                    return false;
            }
        }
        return true;
    }
}












public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> empty = new ArrayList<Integer>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    empty.add(i*9 + j);
                }
            }
        }
        
        sudokuImp(empty, board, 0);
    }
    
    private boolean sudokuImp(ArrayList<Integer> empty, char[][] board, int current){
        if(current == empty.size())
            return true;
        int row = empty.get(current) / 9;
        int col = empty.get(current) % 9;
        for(int val=1; val<=9; val++){
            if(checkPos(board, val, row, col)){
                board[row][col] = (char)(val+'0');
                if(sudokuImp(empty, board, current+1))
                    return true;
                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    private boolean checkPos(char[][] board, int val, int row, int col){
        for(int i=0; i<9; i++){
            if(board[row][i] - '0' == val)
                return false;
            if(board[i][col] - '0' == val)
                return false;
            
            int rowP = 3*(row/3) + i/3;
            int colP = 3*(col/3) + i%3;
            if(board[rowP][colP] - '0' == val)
                return false;
        }
        return true;
    }
}