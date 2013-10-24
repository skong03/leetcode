//练习 -- 用最基本的方法分析：列式，注意数组顺序，数组字符串转换
public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] n1 = getReverse(num1), n2 = getReverse(num2);
        int len1 = n1.length, len2 = n2.length, digit = 0, carry = 0;
        int[] A = new int[len1+len2];
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                digit = n1[i]*n2[j] + A[i+j];
                A[i+j] = digit % 10;
                carry = digit / 10;
                A[i+j+1] += carry;                
            }
        }
        return getString(A);
    }
    private String getString(int[] A){
        String str = new String();
        int i = A.length-1;
        while(i>=0 && A[i]==0) i--;
        while(i >= 0){
             str += A[i] + "";
             i--;
        }
        if(str.length()==0) str = "0";
        return str;
    }
    private int[] getReverse(String str){
        int[] res = new int[str.length()];
        for(int i=0; i<str.length(); i++)
            res[i] = str.charAt(str.length()-1-i)-'0';
        return res;
    }
}




public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        num1 = reverse(num1);
        num2 = reverse(num2);
        int[] res = new int[num1.length()+num2.length()];
        for(int i=0; i<num1.length(); i++)
            for(int j=0; j<num2.length(); j++){
                int tmp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + res[i+j];
                res[i+j+1] = res[i+j+1] + tmp/10;
                res[i+j] = tmp%10;
            }
        int index = 0;
        for(int i=res.length-1; i>=0; i--)
            if(res[i] != 0){
                index = i;
                break;
            }
        String s = "";
        for(int i=index; i>=0; i--)
            s += res[i];
        return s;
    }
    private String reverse(String str){
        String s = "";
        for(int i=str.length()-1; i>=0; i--)
            s += str.charAt(i);
        return s;
    }
}









public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        num1 = reverse(num1);
    	num2 = reverse(num2);
        int[] ans = new int[num1.length() + num2.length()];
        
        int tmp = 0;
        for(int i=0; i<num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                tmp = (num1.charAt(i) - '0')*(num2.charAt(j) - '0') + ans[i+j];
                
				ans[i+j+1] = ans[i+j+1] + tmp/10;

                ans[i+j] = tmp % 10;
            }
        }
        
        int index = 0;
        for(int i=ans.length-1; i>=0; i--){
    		if(ans[i] != 0){
				index = i;
				break;
			}
		}
		
		String res = "";
		for(int i=index; i>=0; i--)
			res = res + ans[i];
			
        return res;
    }
    
    public String reverse(String str){
    	String res = "";
		for(int i=str.length()-1; i>=0; i--)
			res = res + str.charAt(i);
		
		return res;
	}
}