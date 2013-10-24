import java.util.*;

class Test{
    public static void main(String[] args){	
		Palin p = new Palin();
		String s = "abcxcbda";
		
		int resNum = p.palinSeq(s, 0, s.length()-1);
		
		System.out.println(resNum);
		
		resNum = p.palinSeqDP(s);
		
		System.out.println(resNum);
    }
}

class Palin{
	public int palinSeq(String str, int i, int j){
		if((i==j) || (i+1==j && str.charAt(i)!=str.charAt(j)))
			return 1;
		else if(i+1 == j && str.charAt(i) == str.charAt(j))
			return 2;
		else if(str.charAt(i) == str.charAt(j))
			return palinSeq(str, i+1, j-1)+2;
		else
			return Math.max(palinSeq(str, i+1, j), palinSeq(str, i, j-1));
	}
	
	public int palinSeqDP(String s){
		int n = s.length();
		int[][] matrix = new int[n][n];
		for(int i=0; i<n; i++)
			matrix[i][i] = 1;
		for(int len=2; len<=n; len++){
			for(int i=0; i<n-len+1; i++){
				int j = i+len-1;
				if(len==2 && s.charAt(i)==s.charAt(j))
					matrix[i][j] = 2;
				else if(s.charAt(i) == s.charAt(j))
					matrix[i][j] = matrix[i+1][j-1] + 2;
				else
					matrix[i][j] = Math.max(matrix[i+1][j], matrix[i][j-1]);
			}
		}
		
		return matrix[0][n-1];
	}	
}















