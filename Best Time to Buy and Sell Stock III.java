prices:326503
profit:004444
profit:443330

public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(prices.length<2)
            return 0;
        int[] profit=new int[prices.length];
        profit[0]=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                profit[i]=profit[i-1];
            }else{
                profit[i]=Math.max(profit[i-1],prices[i]-min);
            }
        }
//        for(int i:profit){
//        	System.out.println(i);
//        }
        //int[] profit2=new int[prices.length];
        //profit2[prices.length-1]=0;
        int last=prices[prices.length-1];
        int max=0;
        int res=profit[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>last){
                last=prices[i];
                //profit2[i]=profit2[i+1];
            }else{
                max=Math.max(max,last-prices[i]);
                //profit2[i]=max;
                //System.out.println(max);
                if(i>0)
                	res=Math.max(res,profit[i-1]+max);
                //System.out.println(res);
            }
        }
        
//      for(int i:profit2){
//    	System.out.println(i);
//    }
        return res;
    }
}