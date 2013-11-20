public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> res=new ArrayList<Integer>();
        res.add(0);
        if(n==0)
            return res;
        res.add(1);
        for(int i=1;i<n;i++){
            int index=res.size()-1;
            int high=1<<i;
            for(int j=index;j>=0;j--){
                res.add(res.get(j)+high);
            }
        }
        return res;
    }
}


public class Solution {
    public ArrayList<Integer> grayCode(int n) {  
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (n <= 1) {
            resultList.add(0);
            if (n == 1) resultList.add(1);
            return resultList;
        }
    
        ArrayList<Integer> prevList = grayCode(n - 1);
        int highest_bit = 1 << (n - 1);
        for (int i = prevList.size() - 1; i >= 0; i--) {
            resultList.add(prevList.get(i) + highest_bit);
        }
    
        prevList.addAll(resultList);
        return prevList;
    }
}




[0, 1]
2
[0, 1, 3, 2]
4
[0, 1, 3, 2, 6, 7, 5, 4]
8
[0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8]
