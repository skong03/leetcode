public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0], res = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min) min = prices[i];
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}


public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length < 2)
            return 0;        
        
        int pointer = 0;
        int max = 0;
        
        
        return maxImp(prices, max, pointer);
    }
    
    private int maxImp(int[] prices, int max, int pointer){
        if(pointer == prices.length - 1)
            return max;
        
        if(pointer > 0 && prices[pointer] > prices[pointer-1]){
            pointer++;
            return maxImp(prices, max, pointer);
        }
        
        for(int i=pointer; i<prices.length; i++){
            if(i > pointer && prices[i] <= prices[pointer])
                continue;
            int tmp = prices[i] - prices[pointer];
            max = Math.max(max, tmp);
        }
        
        pointer++;
        
        return maxImp(prices, max, pointer);
    }
}














public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length < 2) return 0;

        int buy_date = 0;
        int max_profit = 0;
    
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buy_date]) {
                buy_date = i; 
            }
            int tmp_profit = prices[i] - prices[buy_date];
            if (tmp_profit > max_profit) max_profit = tmp_profit;
        }
        return max_profit;
   }
   
}