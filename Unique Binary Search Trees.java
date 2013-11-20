public class Solution {
    public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int sum=0;
        if(n==1||n==0)//both 0 and 1 return 1;
            return 1;
        else{
            for(int i=0;i<n;i++)
                sum+= numTrees(i)*numTrees(n-i-1);
        }
        
        return sum;
    }
}

//except the root node, there are n-1 node can be distribute, if n==2, this is only 0,1 and 1,0; if n==3, can be 1,1   2,0  0,2
public class Solution {
    HashMap<Integer,Integer> table=new HashMap<Integer,Integer>();
    public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(table.containsKey(n))
            return table.get(n);
        int sum=0;
        if(n==0||n==1)
            return 1;
        else{
            for(int i=0;i<n;i++){
                sum+=numTrees(i)*numTrees(n-i-1);
            }
        }
        table.put(n,sum);
        return sum;
    }
}