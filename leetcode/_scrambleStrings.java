//DP算法未完待续，需要研究

public class Solution {
    public boolean isScramble(String s2, String s1) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length() != s2.length()) return false;
        else if(s1.length() == 1) return s1.charAt(0)==s2.charAt(0);
        else{
            for(int i=1; i<s2.length(); i++){
                String a1 = s1.substring(0, i);
                String a2 = s1.substring(i);
                String b1 = s2.substring(0, i);
                String b2 = s2.substring(i);
                
                if(checkLetters(a1, b1)){
                    if(isScramble(a1, b1) && isScramble(a2, b2)){
                        return true;
                    }
                }
                
                b1 = s2.substring(0, a2.length());
                b2 = s2.substring(a2.length());
                if(checkLetters(a1, b2)){
                    if(isScramble(a1, b2) && isScramble(a2, b1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    private boolean checkLetters(String s1, String s2){
        int[] set = new int[256];
        for(int i=0; i<s1.length(); i++)
            set[s1.charAt(i)-'0']++;
        
        for(int i=0; i<s2.length(); i++){
            if(set[s2.charAt(i)-'0']-- == 0)
                return false;
        }
        
        return true;
    }
}





boolean isScramble(String s1, String s2) {
    if(s1.equals(s2))
        return true;
    boolean[][][] scrambled = new boolean[s1.length()][s2.length()][s1.length() + 1];
    for(int i = 0; i < s1.length(); i++)
        for(int j = 0; j < s2.length(); j++){
            scrambled[i][j][0] = true; 
            scrambled[i][j][1] = s1.charAt(i) == s2.charAt(j);
        }

    for(int i = s1.length() - 1; i >= 0 ; i--)
        for(int j = s2.length() - 1; j >= 0; j--)
            for(int n = 2; n <= Math.min(s1.length() - i, s2.length() - j); n ++)
                for(int m = 1; m < n; m++){
                    scrambled[i][j][n] |= scrambled[i][j][m] && scrambled[i + m][j + m][n - m] || scrambled[i][j + n - m][m] && scrambled[i + m][j][n - m];
                    if(scrambled[i][j][n])  break;
                }
    return scrambled[0][0][s1.length()]; 
}

















public boolean isScramble(String C, String T) {
    if (T.length() != C.length()) {
        return false;
    } else if (T.length() == 1) {
        return T.charAt(0) == C.charAt(0);
    } else {
        for (int i = 1; i < T.length(); i++) {
            String t1 = T.substring(0, i);
            String t2 = T.substring(i);

            String c1 = C.substring(0, t1.length());
            String c2 = C.substring(t1.length());
            if (isEqualSet(t1, c1)) {
                if (isScramble(t1, c1) && isScramble(t2, c2) ) {
                    return true;
                }
            }

            c1 = C.substring(0, t2.length());
            c2 = C.substring(t2.length());
            if (isEqualSet(t1, c2)) {
                if (isScramble(t1, c2) && isScramble(t2, c1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

private boolean isEqualSet(String A, String B) {
    int[] set = new int[256];
    for (char c : A.toCharArray()) {
        set[c]++;
    }
    for (char c : B.toCharArray()) {
        if (set[c]-- == 0) {
            return false;
        }
    }
    return true;
}