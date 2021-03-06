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
