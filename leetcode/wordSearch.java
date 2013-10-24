public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(dfs(board, visited, word, i, j, 1)) return true;
                    visited[i][j] = false;
                }
            }
                
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, String word, int r, int c, int pos){
        if(pos == word.length()) return true;
        int m = board.length, n = board[0].length;
        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        for(int i=0; i<dir.length; i++){
            int row = r + dir[i][0];
            int col = c + dir[i][1];
            if(row>=0 && row<m && col>=0 && col<n && !visited[row][col] && board[row][col]==word.charAt(pos)){
                visited[row][col] = true;
                if(dfs(board, visited, word, row, col, pos+1)) return true;
                visited[row][col] = false;
            }
        }
        return false;
    }
}







public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;
        
        char c = word.charAt(0);
        boolean[][] table = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                if(board[i][j] == c){
                    table[i][j] = true;
                    if(dfs(board, word.substring(1), i, j, table))
                        return true;
                    table[i][j] = false;
                }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int row, int col, boolean[][] table){
        if(word.length() == 0)
            return true;
        
        int r = row-1;
        int c = col;
        if(r>=0 && r<board.length && c>=0 && c<board[0].length && table[r][c]==false && word.charAt(0)==board[r][c]){
            table[r][c] = true;
            if(dfs(board, word.substring(1), r, c, table))
                return true;
            table[r][c] = false;
        }
        
        r = row+1;
        c = col;
        if(r>=0 && r<board.length && c>=0 && c<board[0].length && table[r][c]==false && word.charAt(0)==board[r][c]){
            table[r][c] = true;
            if(dfs(board, word.substring(1), r, c, table))
                return true;
            table[r][c] = false;
        }
        
        r = row;
        c = col-1;
        if(r>=0 && r<board.length && c>=0 && c<board[0].length && table[r][c]==false && word.charAt(0)==board[r][c]){
            table[r][c] = true;
            if(dfs(board, word.substring(1), r, c, table))
                return true;
            table[r][c] = false;
        }
        
        r = row;
        c = col+1;
        if(r>=0 && r<board.length && c>=0 && c<board[0].length && table[r][c]==false && word.charAt(0)==board[r][c]){
            table[r][c] = true;
            if(dfs(board, word.substring(1), r, c, table))
                return true;
            table[r][c] = false;
        }
        
        return false;
    }
}