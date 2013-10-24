public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board==null || board.length==0) return;
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O') setEdge(board, i, j);
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                if(board[i][j]=='+') board[i][j] = 'O';
            }
    }
    private void setEdge(char[][] board, int row, int col){
        int m = board.length, n = board[0].length;
        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        board[row][col] = '+';
        for(int i=0; i<dir.length; i++){
            int r = row + dir[i][0];
            int c = col + dir[i][1];
            if(r>=0 && r<m && c>=0 && c<n && board[r][c]=='O') setEdge(board, r, c);
        }
    }
}









public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O') drawPlus(board, i, 0);
            if(board[i][n-1] == 'O') drawPlus(board, i, n-1);
        }
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O') drawPlus(board, 0, j);
            if(board[m-1][j] == 'O') drawPlus(board, m-1, j);
        }
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '+') board[i][j] = 'O';
            }
    }
    private void drawPlus(char[][] board, int r, int c){
        int m = board.length, n = board[0].length;
        int[][] dir = {
            {0, 1},{0, -1},{1, 0},{-1, 0}
        };
        board[r][c] = '+';
        for(int i=0; i<4; i++){
            int row = r + dir[i][0], col = c + dir[i][1];
            if(row>=0 && row<m && col>=0 && col<n){
                if(board[row][col] == 'O') drawPlus(board, row, col);
            }
        }
    }
}






public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length <= 2)
            return;
  // this is step 1
        for(int i=0; i<board.length; i++){
            if(board[i][0] == 'O')
                transEdge(board, i, 0);
            if(board[i][board.length-1] == 'O')
                transEdge(board, i, board.length-1);
        }
       
        for(int j=0; j<board[0].length; j++){
            if(board[0][j] == 'O')
                transEdge(board, 0, j);
            if(board[board[0].length-1][j] == 'O')
                transEdge(board, board[0].length-1, j);
        }
       
  // step 2
        for(int i=1; i<board.length-1; i++){
            for(int j=1; j<board[0].length-1; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
       
  // step 3
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '+')
                    board[i][j] = 'O';
            }
        }
    }
   
    private void transEdge(char[][] board, int i, int j){
        int tmp_i = i - 1;
        int tmp_j = j;
        if(checkPos(board, tmp_i, tmp_j) && board[tmp_i][tmp_j] == 'O'){
            board[tmp_i][tmp_j] = '+';
            transEdge(board, tmp_i, tmp_j);
        }
       
        tmp_i = i;
        tmp_j = j + 1;
        if(checkPos(board, tmp_i, tmp_j) && board[tmp_i][tmp_j] == 'O'){
            board[tmp_i][tmp_j] = '+';
            transEdge(board, tmp_i, tmp_j);
        }
       
        tmp_i = i + 1;
        tmp_j = j;
        if(checkPos(board, tmp_i, tmp_j) && board[tmp_i][tmp_j] == 'O'){
            board[tmp_i][tmp_j] = '+';
            transEdge(board, tmp_i, tmp_j);
        }
       
        tmp_i = i;
        tmp_j = j - 1;
        if(checkPos(board, tmp_i, tmp_j) && board[tmp_i][tmp_j] == 'O'){
            board[tmp_i][tmp_j] = '+';
            transEdge(board, tmp_i, tmp_j);
        }
    }
   
    private boolean checkPos(char[][] board, int i, int j){
        if(i >=0 && i < board.length && j >= 0 && j < board[0].length)
            return true;
        else
            return false;
    }
}