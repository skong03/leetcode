public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int res=0;
        if(prices.length<2)
            return 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                res+=prices[i]-prices[i-1];
        }
        return res;
    }
}