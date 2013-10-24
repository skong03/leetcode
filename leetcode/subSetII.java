public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(num);
        
        subImp(res, num, 0);
        
        return res;
    }
    
    private void subImp(ArrayList<ArrayList<Integer>> res, int[] s, int pos){
        if(pos == s.length)
            return;
        
        ArrayList<ArrayList<Integer>> resCopy = new ArrayList<ArrayList<Integer>>(res);
        for(ArrayList<Integer> ex : resCopy){
            ArrayList<Integer> tmp = new ArrayList<Integer>(ex);
            tmp.add(s[pos]);
            if(!res.contains(tmp))
                res.add(tmp);
        }
        
        subImp(res, s, pos+1);
    }
}