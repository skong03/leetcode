public class Solution {//first consider %2 then consider positive and negtive
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
            return 1;
        double half=pow(x,n/2);
        
        if(n%2==0)
            return half*half;
        else if(n>0)
            return half*half*x;
        else
            return half*half/x;
    }
}//need to write the else, and else if, or write blow


public class Solution {
    public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n==0)
            return 1;
        
        double half=pow(x,n/2);
        if(n%2==0)
            return half*half;
        if(n>0)
            return half*half*x;
        
        return half*half/x;
    }
}