public class Solution {
    public boolean isNumber(String s) {
    	int[][] statetable = { { -1, 0, 3, 1, 2, -1 }, { -1, 8, -1, 1, 4, 5 },
				{ -1, -1, -1, 4, -1, -1 }, { -1, -1, -1, 1, 2, -1 },
				{ -1, 8, -1, 4, -1, 5 }, { -1, -1, 6, 7, -1, -1 },
				{ -1, -1, -1, 7, -1, -1 }, { -1, 8, -1, 7, -1, -1 },
				{ -1, 8, -1, -1, -1, -1 } };
		int i = 0;
		int state = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			int type = 0;
			if (ch == ' ')
				type = 1;
			else if (ch == '+' || ch == '-')
				type = 2;
			else if (ch >= '0' && ch <= '9')
				type = 3;
			else if (ch == '.')
				type = 4;
			else if (ch == 'e')
				type = 5;

			state = statetable[state][type];
			if (state == -1)
				return false;
			else
				i++;
		}
		return state == 1 || state == 4 || state == 7 || state == 8;
	}
}