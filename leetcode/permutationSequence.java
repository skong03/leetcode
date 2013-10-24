public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] factor = new int[n];
        factor[0] = 1;
        for(int i=1; i<n; i++)
            factor[i] = factor[i-1]*i;
        
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        
        for(int i=n-1; i>=0; i--){
            int s = 1;
            while(k > factor[i]){
                s++;
                k -= factor[i];
            }
            
            for(int j=0; j<n; j++){
                if(j+1<=s && visited[j])
                    s++;
            }
            
            visited[s-1] = true;
            sb.append(s);
        }
        
        return sb.toString();
    }
}