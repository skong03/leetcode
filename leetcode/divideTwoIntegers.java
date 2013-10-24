public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long num = Math.abs((long)dividend), div = Math.abs((long)divisor);
        boolean sign = ((dividend>0 && divisor>0) || (dividend<0 && divisor<0))?true:false;
        long cur = 0, res = 0;
        for(int i=31; i>=0; i--){
            cur = cur<<1;
            cur = cur | (num>>i & 1);
            res = res<<1;
            if(cur >= div){
                cur = cur - div;
                res++;
            }
        }
        return sign?(int)res:-(int)res;
    }
}




//"<<" means: 把该数值对应的二进制的数值向左移动n位
// 2 << 3 ：把10向左移动2位：1000 = 16
public class Solution{
    public int divide(int dividend, int divisor) {
        boolean signA = dividend >= 0, signB = divisor > 0;
    
        long num = Math.abs((long) dividend), div = Math.abs((long) divisor), res = 0, curr = 0;
        // using Long division
        for (int idx = 31; idx >= 0; idx--) {
            curr <<= 1;
            curr |= ((num >> idx) & 1);
    
            res <<= 1;
            if (curr >= div) {
                curr -= div;
                res |= 1;
            }
        }
    
        if (signA ^ signB)
            return -(int) res;
        return (int) res;
    }
}

//水印人生の方法
public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long a = Math.abs((long) dividend), b=Math.abs((long) divisor);
        long[] res= dividePos(a,b);
        long temp = dividend>0&&divisor<0||dividend<0&&divisor>0?-res[0]:res[0];
        return (int) temp;
    }
    
    public long[] dividePos(long a, long b){
        long[] res = new long[2];
        if(a<b){
            res[0]=0;
            res[1]=a;
        }else if(a==b){
            res[0]=1;
            res[1]=0;
        }else{
            long[] temp=dividePos(a>>1,b);
            res[0] = temp[0]<<1;
            res[1] = temp[1]<<1;
            if((a & 1)==1) res[1]+=1;
            if(res[1]>=b){
                res[0]+=1;
                res[1]-=b;
            }
        }
        return res;
    }
}



//第三个方式：




public class Solution {
    public int divide(int divid, int divis) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long dividend = divid;
        long divisor = divis;
        
        boolean sign = false;
        
        if(dividend<0) {
            sign = true;
            dividend = -dividend;
        }
        
        if(divisor<0) {
            sign = !sign;
            divisor = -divisor;
        }
        
        int res = 0;
        long temp = 0;
        while( dividend >= divisor) {
            int i=1;
            temp = divisor;
            
            while( (temp<<1) <= dividend){
                temp <<= 1;
                i <<= 1;
            }
            res |= i;
            dividend -= temp;
        }
        return sign ? -res : res;
    }
}


