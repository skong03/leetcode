//Integer -> Rome.
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(num > 0){
            int times = num/nums[i];
            num -= times*nums[i];
            for(;times>0;times--){
                res.append(symbol[i]);
            }
            i++;
        }
        return res.toString();    
    }
}
//2nd Version
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] intList = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romList = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int times = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<intList.length; i++){
            times = num/intList[i];
            num = num - times*intList[i];
            for(int j=0; j<times; j++)
                sb.append(romList[i]);
        }
        return sb.toString();
    }
}

// Rome to Integer.
public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int num = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(i-1 >= 0 && map.get(s.charAt(i-1)) < map.get(s.charAt(i))){
                num += map.get(s.charAt(i)) - map.get(s.charAt(i-1));
                i--;
            }
            else
                num += map.get(s.charAt(i));
        }
        
        return num;
    }
}