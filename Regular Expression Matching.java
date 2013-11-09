public class Solution {
	public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null) return p == null;
        return m(s, 0, p, 0);
    }
	
	public boolean m(String s, int i, String p, int j){
		if(j==p.length())
			return i==s.length();
		if(j==p.length()-1||p.charAt(j+1)!='*'){//j is last or next !=*
		    if(i==s.length())
				return false;
			return ((s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')&&m(s,i+1,p,j+1));
		}else{
			while(i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))  
		        if (m(s, i++, p, j + 2)) return true;
			return m(s, i, p, j + 2);
		}
	}
}