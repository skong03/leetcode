public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        if(s==null || s.length()==0) return false;
        int[][] matrix = {
    		{-1, -1, 2, 3, -1},
			{-1, -1, -1, -1, -1},
			{-1, 4, 2, 5, -1},
			{-1, -1, 6, -1, -1},
			{7, -1, 8, -1, -1},
			{-1, 4, 9, -1, -1},
			{-1, 4, 9, -1, -1},
			{-1, -1, 8, -1, -1},
			{-1, -1, 8, -1, -1},
			{-1, 4, 9, -1, -1},
		};
        int state = 0;
        char c = s.charAt(0);
        if(c=='+' || c=='-') state = 0;
        else if(c=='e' || c=='E') state = 1;
        else if(c>='0' && c<='9') state = 2;
        else if(c=='.') state = 3;
        else return false;
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)=='+' || s.charAt(i)=='-') state = matrix[state][0];
            else if(s.charAt(i)=='e' || s.charAt(i)=='E') state = matrix[state][1];
            else if(s.charAt(i)>='0' && s.charAt(i)<='9') state = matrix[state][2];
            else if(s.charAt(i)=='.') state = matrix[state][3];
            else state = -1;
            if(state == -1) return false;
        }
        return state==2 || state==8 || state==9 || state==5 || state==6;
    }
}