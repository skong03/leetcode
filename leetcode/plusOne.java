public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(allNine(digits)){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        
        if(digits[digits.length-1] != 9){
            digits[digits.length-1]++;
            return digits;
        }
        
        int carry = 1;
        int probe = digits.length - 1;
        while(carry == 1 && probe >= 0){
            carry = (digits[probe] + 1) / 10;
            digits[probe] = (digits[probe]+1) % 10;
            probe--;
        }
        return digits;
    }
        
    private boolean allNine(int[] digits){
        for(int i=0; i<digits.length; i++)
            if(digits[i] != 9)
                return false;
        
        return true;
    }
}