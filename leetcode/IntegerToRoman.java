public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String ge = "";
        String shi = "";
        String bai = "";
        String qian = "";
        
        int g = num % 10;
        int s = (num/10) % 10;
        int b = (num/100) % 10;
        int q = (num/1000) % 10;
        
        switch(g){
            case 1:
                ge = "I";
                break;
            case 2:
                ge = "II";
                break;
            case 3:
                ge = "III";
                break;
            case 4:
                ge = "IV";
                break;
            case 5:
                ge = "V";
                break;
            case 6:
                ge = "VI";
                break;
            case 7:
                ge = "VII";
                break;
            case 8:
                ge = "VIII";
                break;
            case 9:
                ge = "IX";
                break;
        }
        
        switch(s){
            case 1:
                shi = "X";
                break;
            case 2:
                shi = "XX";
                break;
            case 3:
                shi = "XXX";
                break;
            case 4:
                shi = "XL";
                break;
            case 5:
                shi = "L";
                break;
            case 6:
                shi = "LX";
                break;
            case 7:
                shi = "LXX";
                break;
            case 8:
                shi = "LXXX";
                break;
            case 9:
                shi = "XC";
                break;
        }
        
    	switch(b){
            case 1:
                bai = "C";
                break;
            case 2:
                bai = "CC";
                break;
            case 3:
                bai = "CCC";
                break;
            case 4:
                bai = "CD";
                break;
            case 5:
                bai = "D";
                break;
            case 6:
                bai = "DC";
                break;
            case 7:
                bai = "DCC";
                break;
            case 8:
                bai = "DCCC";
                break;
            case 9:
                bai = "CM";
                break;
        }
        
    	switch(q){
            case 1:
                qian = "M";
                break;
            case 2:
                qian = "MM";
                break;
            case 3:
                qian = "MMM";
                break;
            case 4:
                qian = "MCD";
                break;
            case 5:
                qian = "MD";
                break;
            case 6:
                qian = "MDC";
                break;
            case 7:
                qian = "MDCC";
                break;
            case 8:
                qian = "MDCCC";
                break;
            case 9:
                qian = "MCM";
                break;
        }
        
        String res = qian + bai + shi + ge;
        return res;
    }
}
















