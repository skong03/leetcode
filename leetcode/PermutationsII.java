public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        permuteImp(res, num, 0);
        
        return res;
    }
    
    private void permuteImp(ArrayList<ArrayList<Integer>> res, int[] num, int pos){
        if(pos == num.length)
            return;
        else if(pos == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(num[pos]);
            res.add(tmp);
        }
        else{
            ArrayList<ArrayList<Integer>> resCopy = new ArrayList<ArrayList<Integer>>(res);
            for(int i=0; i<resCopy.size(); i++){
                res.remove(0);
            }
            for(ArrayList<Integer> ex : resCopy){
                for(int i=0; i<=ex.size(); i++){
                    ArrayList<Integer> tmp = new ArrayList<Integer>(ex);
                    tmp.add(i, num[pos]);
                    if(!res.contains(tmp))
                        res.add(tmp);
                }
            }
        }
        
        permuteImp(res, num, pos+1);
    }
}