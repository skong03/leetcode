public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        for(int i=1; i<prices.length; i++)
            res += prices[i]>prices[i-1]?(prices[i]-prices[i-1]):0;
        return res;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        
        for(int i=0; i<prices.length; i++){
            if(i > 0 && prices[i] > prices[i-1])
                res = res + prices[i] - prices[i-1];
        }
        
        return res;
    }
}