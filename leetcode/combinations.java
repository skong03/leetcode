public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        boolean[] visited = new boolean[n];
        dfs(res, level, visited, k, 0);
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> level, boolean[] visited, int k, int pos){
        if(level.size() == k){
            res.add(new ArrayList<Integer>(level));
            return;
        }
        for(int i=pos; i<visited.length; i++){
            if(!visited[i]){
                level.add(i+1);
                visited[i] = true;
                dfs(res, level, visited, k, i+1);
                level.remove(level.size()-1);
                visited[i] = false;
            }
        }
    }
}



public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(n < 1 || k < 1 || n < k)
            return res;
        
        if(k == 1){
            for(int i=1; i<=n; i++){
                ArrayList<Integer> level = new ArrayList<Integer>();
                level.add(i);
                res.add(level);
            }
            return res;
        }
        
        for(int i=n; i>=k; i--){
            for(ArrayList<Integer> level : combine(i-1, k-1)){
                level.add(i);
                res.add(level);
            }
        }
        
        return res;
    }
}