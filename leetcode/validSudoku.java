public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0;  i<9; i++)
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;
                char tmp = board[i][j];
                board[i][j] = ',';
                if(!checkPos(board, tmp, i, j))
                    return false;
                board[i][j] = tmp;
            }
        return true;
    }
    
    private boolean checkPos(char[][] board, char tmp, int row, int col){
        int val = tmp + '0';
        for(int i=0; i<9; i++){
            if(board[row][i] == tmp)
                return false;
            if(board[i][col] == tmp)
                return false;
            int rowP = 3*(row/3) + i/3;
            int colP = 3*(col/3) + i%3;
            if(board[rowP][colP] == tmp)
                return false;
        }
        return true;
    }
}