public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pa = a.length()-1, pb = b.length()-1, carry = 0, digit = 0;
        StringBuilder sb = new StringBuilder();
        while(pa>=0 && pb>=0){
            digit = (a.charAt(pa)-'0' + b.charAt(pb)-'0' + carry) % 2;
            carry = (a.charAt(pa)-'0' + b.charAt(pb)-'0' + carry) / 2;
            sb.insert(0, digit);
            pa--;
            pb--;
        }
        while(pa>=0){
            digit = (a.charAt(pa)-'0' + carry) % 2;
            carry = (a.charAt(pa)-'0' + carry) / 2;
            sb.insert(0, digit);
            pa--;
        }
        while(pb>=0){
            digit = (b.charAt(pb)-'0' + carry) % 2;
            carry = (b.charAt(pb)-'0' + carry) / 2;
            sb.insert(0, digit);
            pb--;
        }
        if(carry == 1) sb.insert(0, carry);
        return sb.toString();
    }
}




public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        String sumStr = "";
        
        while(i >= 0 || j >= 0){
            int bitSum = 0;
            int bit;
            if(i >= 0 && j >= 0){
                bitSum = Integer.parseInt(a.substring(i, i+1)) + Integer.parseInt(b.substring(j, j+1)) + carry;
                i--;
                j--;
            }
            else if(i >= 0){
                bitSum = Integer.parseInt(a.substring(i, i+1)) + carry;
                i--;
            }
            else{
                bitSum = Integer.parseInt(b.substring(j, j+1)) + carry;
                j--;
            }
            
            bit = bitSum % 2;
            carry = bitSum/2;
            sumStr = bit + sumStr;
        }
        if(carry == 1)
            sumStr = carry + sumStr;
        
        return sumStr;
    }
}