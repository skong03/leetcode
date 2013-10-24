public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<numRows; i++){
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                int val = getVal(res, i, j);
                level.add(val);
            }
            res.add(level);
        }
        
        return res;
    }
    
    private int getVal(ArrayList<ArrayList<Integer>> res, int i, int j){
        if(i == 0 || j == 0 || j == i)
            return 1;
        return res.get(i-1).get(j-1) + res.get(i-1).get(j);
    }
}