public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        res.add(new ArrayList<Integer>());
        dfs(res, level, S, 0);
        
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> level, int[] S, int pos){
        for(int i=pos; i<S.length; i++){
            if(!level.contains(S[i])){
                level.add(S[i]);
                res.add(new ArrayList<Integer>(level));
                dfs(res, level, S, i+1);
                level.remove(level.size()-1);
            }
        }
    }
}




public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(S);
       
        res.add(tmp);
        subImp(res, S, 0);
       
        return res;
    }
   
    private void subImp(ArrayList<ArrayList<Integer>> res, int[] s, int pos){
        if(pos == s.length)
            return;
       
        ArrayList<ArrayList<Integer>> resCopy = (ArrayList<ArrayList<Integer>>)res.clone();
        for(ArrayList<Integer> ex : resCopy){
            ArrayList<Integer> tmp = new ArrayList<Integer>(ex);
            tmp.add(s[pos]);
            res.add(tmp);
        }
       
        subImp(res, s, pos+1);
    }
}