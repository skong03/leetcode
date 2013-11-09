/* 1, the both dfs and check are boolean
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> pos=new ArrayList<Integer>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    pos.add(i*9+j);
            }
        }
        dfs(board,pos,0);
    }
    public boolean dfs(char[][] board, ArrayList<Integer> pos, int index){
        if(index==pos.size())
            return true;
        int x=pos.get(index)/9;
        int y=pos.get(index)%9;
        
        for(char num='1';num<='9';num++){
            if(check(board, x, y, num)){
                board[x][y]=num;
                if(dfs(board, pos, index+1))
                    return true;
                board[x][y]='.';
            }
        }
        return false;
    }
    public boolean check(char[][] board, int i, int j, char num){//check if the num valid in the the position(i,j) in board.
        for(int x=0;x<9;x++){
            if(board[i][x]==num||board[x][j]==num)
                return false;
            int a=3*(i/3)+x/3;
            int b=3*(j/3)+x%3;
            if(board[a][b]==num)
                return false;
        }
        return true;
    }
}




/*this method is wrong, can't fix it, I don't know why???????*, remember the above one
public void help(char[][] board, ArrayList<Integer> pos, int i){
 
        if(i==pos.size()){
            return;}
        int p=pos.get(i);
        
        for(char c='1';c<='9';c++){
            board[p/9][p%9]=c;//fit the num in 
            if(check(board, p/9,p%9,))//check if valid
                help(board,pos,i+1);//go to next number....
        }
    }