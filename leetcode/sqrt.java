//���ַ�
public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long low = 0, high = x;
        long mid;
        while(low <= high){
            mid = (low+high)/2;
            if(mid*mid == x) return (int)mid;
            else if(mid*mid < x) low = mid+1;
            else high = mid-1;
        }
        mid = (low+high)/2;
        return (int)mid;
    }
}

//ţ�ƺ���ţ�ٵ�����
public class Solution {
    public int sqrt(int x) {
    	double x0 = x / 2.0;
		double x1 = (x0 + x / x0) / 2.0;
		while (Math.abs(x1 - x0) > 0.00001) {
			x0 = x1;
			x1 = (x0 + x / x0) / 2.0;
		}
        return (int) x1;
    }
}
