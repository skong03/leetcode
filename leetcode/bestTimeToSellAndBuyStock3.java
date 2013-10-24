public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0], max = prices[prices.length-1], res = 0;
        int[] p1 = new int[prices.length], p2 = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min) min = prices[i];
            p1[i] = Math.max(prices[i]-min, i>0?p1[i-1]:0);
        }
        for(int i=prices.length-1; i>=0; i--){
            if(prices[i] > max) max = prices[i];
            p2[i] = Math.max(max-prices[i], i<prices.length-1?p2[i+1]:0);
            res = Math.max(p1[i]+p2[i], res);
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
        
        int res = 0;        
        int[] previous = new int[prices.length];
        int[] following = new int[prices.length];
        int buy_date = 0;
        int sell_date = prices.length - 1;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < prices[buy_date])
                buy_date = i;
            int tmp = prices[i] - prices[buy_date];
            if(i > 0)
                previous[i] = Math.max(previous[i-1], tmp);
        }
        
        for(int j=prices.length-1; j>=0; j--){
            if(prices[j] >prices[sell_date])
                sell_date = j;
            int tmp = prices[sell_date] - prices[j];
            if(j < prices.length - 1)
                following[j] = Math.max(following[j+1], tmp);
            
            res = Math.max(res, previous[j] + following[j]);
        }
        
        return res;
    }
}