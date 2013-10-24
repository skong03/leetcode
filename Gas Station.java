public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] remin= new int[gas.length];
        
        for(int i=0;i<gas.length;i++){
            remin[i]=gas[i]-cost[i];
        }
        int p1=0;
        int p2=gas.length-1;
        int sum=remin[0];
        while(p1<=p2&&p1<gas.length-1)
        {
            if(sum>=0)
            {
                sum=sum+remin[p1+1];
                p1++;
            }
            else
            {
                sum=sum+remin[p2];
                p2--;
            }
        }
        if(sum<0)
            return -1;
        return p1;
    }
}