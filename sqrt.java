public class Solution {
  public int sqrt(int x) {
    if(x==0)
        return 0;
    if(x==1)
        return 1;
    int s=0;
    int l=x;
    int mid=0;
    while(l>s+1)
    {
        mid=(s+l)/2;
        if(mid==x/mid)
            return mid;
        if(mid>x/mid)
            l=mid;
            else 
                s=mid;
    }
    
    return s;//very important, not return mid
  }
}