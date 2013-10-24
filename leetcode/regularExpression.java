public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length() == 0) return s.length() == 0;
        if(p.length()==1 || p.charAt(1)!='*'){
            if(s.length()==0 || (p.charAt(0)!='.' && s.charAt(0)!=p.charAt(0))) return false;
            return isMatch(s.substring(1), p.substring(1));
        }
        else{
            int i = -1;
            while(i<s.length() && (i<0 || p.charAt(0)=='.' || s.charAt(i)==p.charAt(0))){
                if(isMatch(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
            return false;
        }
    }
}





public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        if (p.length()==0) return s.length()==0; //�жϵ�sɨ���꣬p�Ƿ�ɨ����
        if (p.length()==1 ||p.charAt(1)!='*'){ //���p�ĵڶ�λ����"*"
            if (s.length()==0 ||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0)))
                return false; //��Ϊp�ĵڶ�λ����"*"��ֻ�ܱȽ�p����һλ��s����һλ
            return isMatch(s.substring(1),p.substring(1));
        }else{ //���p�ĵڶ�λ��"*"
            int i = -1; //p�ĵڶ�λ��"*"��ʱ�����Ƿֱ���s��ǰiλ������������p"*"�����һλ���бȽ�
            while(i<s.length()&&(i<0||p.charAt(0)=='.'||p.charAt(0)==s.charAt(i))){
                if (isMatch(s.substring(i+1),p.substring(2)))
                    return true;
				i++;
            }
        }
        return false;
    }
}

//���� Run s = "aab" , p = "c*a*b"
// p�ڶ�λΪ*����Ϊi=-1<0������������ݹ� isMatch("aab", "a*b") ���1
// p�ĵڶ�λ��Ϊ*����Ϊi=-1<0������������ݹ� isMatch("aab",b) ���ַ���False���ص��ݹ����1 i++ 
// ����i��ֵΪ0��p.charAt(0) = a, s.charAt(i) = a �������� ����ݹ�isMatch("ab","b")  ���ַ���False���ص��ݹ����1 i++ 
// ����i��ֵΪ1��p.charAt(1) = a, s.charAt(i) = a �������� ����ݹ�isMatch("b","b") True ����

// �ڳ���������i=-1����Ϊ�� "*"����Match 0���ַ������
// i++ ����������"*" match�ĸ���





public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length() == 0) return s.length() == 0;
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() == 0 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        }
        else{
            int i = -1;
            while(i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                else
                    i++;
            }
        }
        
        return false;
    }
}