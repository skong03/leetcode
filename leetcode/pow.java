class Test{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.pow(0, 11));
	}
}

public class Solution {	
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function			
		if(n == 0)
            return 1.0;
		
		if(x == 0 && n != 0)
            return 0;
		
        double half = pow(x, n/2);
        if((n % 2) == 0)
            return half * half;
        else if(n > 0)
            return half * half * x;
        else
            return half * half / x;
    }
}


public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
            return 1;
        
        if(n < 0)
            return 1.0/pow(x, -n);
        
        double half = pow(x, n/2);
        if(n%2 == 0)
            return half*half;
        else if(n > 0)
            return half*half*x;
        else
            return half*half/x;
    }
}

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
            return 1;
        else if(n == 1)
            return x;
        else if(n < 0)
            return 1/pow(x, -n);
        
        double half = pow(x, n/2);
        return n%2==0?half*half:half*half*x;
    }
}