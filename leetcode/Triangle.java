public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}




public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        dfs(triangle, 0, 0, 0, pq);
        return pq.peek();
    }
    private void dfs(ArrayList<ArrayList<Integer>> tri, int sum, int steps, int pos, PriorityQueue<Integer> pq){
        if(steps == tri.size()){
            pq.add(sum);
            return;
        }
        for(int i=0; i<=1; i++){
             if(pos+i < tri.get(steps).size()){
                sum += tri.get(steps).get(pos+i);
                dfs(tri, sum, steps+1, pos+i, pq);
                sum -= tri.get(steps).get(pos+i);
             }
        }
    }
}