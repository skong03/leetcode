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
        if (p.length()==0) return s.length()==0; //判断当s扫描完，p是否扫瞄完
        if (p.length()==1 ||p.charAt(1)!='*'){ //如果p的第二位不是"*"
            if (s.length()==0 ||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0)))
                return false; //因为p的第二位不是"*"，只能比较p的这一位和s的这一位
            return isMatch(s.substring(1),p.substring(1));
        }else{ //如果p的第二位是"*"
            int i = -1; //p的第二位是"*"的时候，我们分别用s的前i位，依次与跳过p"*"后的那一位进行比较
            while(i<s.length()&&(i<0||p.charAt(0)=='.'||p.charAt(0)==s.charAt(i))){
                if (isMatch(s.substring(i+1),p.substring(2)))
                    return true;
				i++;
            }
        }
        return false;
    }
}

//例如 Run s = "aab" , p = "c*a*b"
// p第二位为*，因为i=-1<0符合条件进入递归 isMatch("aab", "a*b") 序号1
// p的第二位又为*，因为i=-1<0符合条件进入递归 isMatch("aab",b) 发现返回False，回到递归序号1 i++ 
// 现在i的值为0，p.charAt(0) = a, s.charAt(i) = a 符合条件 进入递归isMatch("ab","b")  发现返回False，回到递归序号1 i++ 
// 现在i的值为1，p.charAt(1) = a, s.charAt(i) = a 符合条件 进入递归isMatch("b","b") True 返回

// 在程序里设置i=-1就是为了 "*"可能Match 0个字符的情况
// i++ 是依次增加"*" match的个数





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