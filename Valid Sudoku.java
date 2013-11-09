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


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean f=true;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                    continue;
                else
                {
                    char temp=board[i][j];
                    board[i][j]='.';
                    if(check(board,temp,i,j))
                    {
                        f=true;
                    }
                    else
                        return false;
                    //board[i][]
                }
            }
        }
        
        return f;
    }
    
    public boolean check(char[][] board, char temp, int i, int j)
    {
        for(int a=0;a<9;a++)
        {
            if(board[i][a]==temp||board[a][j]==temp)
                return false;
            int x=3*(i/3)+a/3;
            int y=3*(j/3)+a%3;
            if(board[x][y]==temp)
                return false;
        }
        return true;
    }
}


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'&&!check(board, i,j))
                    return false;
            }
        }
        return true;
    }
    
    public boolean check(char[][] board, int i, int j){
        char temp=board[i][j];
        board[i][j]='.';
        for(int k=0;k<9;k++){
            if(board[i][k]==temp||board[k][j]==temp)
                return false;
            int x=(i/3)*3+k/3;
            int y=(j/3)*3+k%3;//one %3, another /3, no matter who did this
            if(board[x][y]==temp)
                return false;
        }
        board[i][j]=temp;
        return true;
    }
}