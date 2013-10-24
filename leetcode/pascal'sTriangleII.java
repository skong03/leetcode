public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<rowIndex+1; i++){
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                int val = getVal(res, i, j);
                level.add(val);
            }
            res.add(level);
        }
        
        return res.get(rowIndex);
    }
    
    private int getVal(ArrayList<ArrayList<Integer>> res, int i, int j){
        if(i == 0 || j == 0 || j == i)
            return 1;
        return res.get(i-1).get(j-1) + res.get(i-1).get(j);
    }
}





public ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> resultList = new ArrayList<Integer>();
    if (rowIndex == 0) {
        resultList.add(1);
        return resultList;
    }
    // Initial
    resultList.add(1);
    resultList.add(1);

    for (int i = 2; i <= rowIndex; i++) {
        resultList.add(1, resultList.get(0) + resultList.get(1));       
        for (int j = 2; j < resultList.size() - 1; j++) {
            resultList.set(j, resultList.get(j) + resultList.get(j + 1));
        }
    }

    return resultList;
}