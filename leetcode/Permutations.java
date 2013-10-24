public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        permuteImp(res, num, 0);
        
        return res;
    }
    
    private void permuteImp(ArrayList<ArrayList<Integer>> res, int[] s, int pos){
        if(pos == s.length)
            return;
        else if(pos == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(s[pos]);
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
                    tmp.add(i, s[pos]);
                    res.add(tmp);
                }
            }
        }
        
        permuteImp(res, s, pos+1);
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        permuteImp(res, num, 0);
        
        return res;
    }
    
    private void permuteImp(ArrayList<ArrayList<Integer>> res, int[] s, int pos){
        if(pos == s.length)
            return;
        else if(pos == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(s[pos]);
            res.add(tmp);
        }
        else{
            ArrayList<ArrayList<Integer>> resNew = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> ex : res){
                for(int i=0; i<=ex.size(); i++){
                    ArrayList<Integer> tmp = new ArrayList<Integer>(ex);
                    tmp.add(i, s[pos]);
                    resNew.add(tmp);
                }
            }
            res = resNew;
        }
        
        permuteImp(res, s, pos+1);
    }
}