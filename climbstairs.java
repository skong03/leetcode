public class solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0||n==1)
            return 1;
        int[] a= new int[n+1];
        a[0]=1;
        a[1]=1;
        dp(n,a);
        //p(a);
        return a[n];
    }
    
    public int dp(int n, int[] a)
    {
        if(a[n]>0)
        {
            return a[n];
        }
        else 
        {
        	a[n]=dp(n-1,a)+dp(n-2,a);
            return dp(n-1,a)+dp(n-2,a);
        }
    }
}


public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] test= new int[n+1];
        
        test[0]=1;
        test[1]=2;
        
        for(int i=2; i<n;i++)
        {
            test[i]=test[i-1]+test[i-2];
        }
        
        return test[n-1];
    }
}

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<1)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int[] map=new int[n+1];
        return dp(map, n);
        
    }
    
    public int dp(int[] map, int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(map[n]>0)
            return map[n];
        else
            {
                map[n]=dp(map, n-1)+dp(map,n-2);
                return map[n];
            }
    }
}