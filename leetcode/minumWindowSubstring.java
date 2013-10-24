//Array·¨
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] needFind = new int[256];
        int[] hasFind = new int[256];
        int cnt = 0, len = Integer.MAX_VALUE, start = 0;
        String res = "";
        for(char c : T.toCharArray()) needFind[c]++;
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(needFind[c] == 0) continue;
            hasFind[c]++;
            if(hasFind[c] <= needFind[c]) cnt++;
            if(cnt == T.length()){
                while(hasFind[S.charAt(start)]==0 || hasFind[S.charAt(start)]>needFind[S.charAt(start)]){
                    if(hasFind[S.charAt(start)]>needFind[S.charAt(start)]) hasFind[S.charAt(start)]--;
                    start++;
                }
                if(i-start+1 < len){
                    res = S.substring(start, i+1);
                    len = i-start+1;
                }
            }
        }
        return res;
    }
}

//HashMap·¨
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hasFind = new HashMap<Character, Integer>();
        String total = "" + S + T, res = "";
        int cnt = 0, start = 0, len = Integer.MAX_VALUE;
        for(char c : total.toCharArray()){
            needFind.put(c, 0);
            hasFind.put(c, 0);
        }
        for(char c : T.toCharArray()) needFind.put(c, needFind.get(c)+1);
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(!needFind.containsKey(c)) continue;
            hasFind.put(c, hasFind.get(c)+1);
            if(hasFind.get(c) <= needFind.get(c)) cnt++;
            if(cnt == T.length()){
                while(hasFind.get(S.charAt(start))==0 || hasFind.get(S.charAt(start))>needFind.get(S.charAt(start))){
                    if(hasFind.get(S.charAt(start))>needFind.get(S.charAt(start))) hasFind.put(S.charAt(start), hasFind.get(S.charAt(start))-1);
                    start++;
                }
                if(i-start+1 < len){
                    res = S.substring(start, i+1);
                    len = i-start+1;
                }
            }
        }
        return res;
    }
}













public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] needFind = new int[256];
        int[] hasFind = new int[256];
        int start = 0;
        int left = 0;
        int right = 0;
        int winLength = Integer.MAX_VALUE;
        String win = "";
        int cnt = 0;
        
        for(int i=0; i<T.length(); i++)
            needFind[T.charAt(i)]++;
        
        
        for(int i=0; i<S.length(); i++){
            if(needFind[S.charAt(i)] == 0)
                continue;
            
            hasFind[S.charAt(i)]++;
            
            if(hasFind[S.charAt(i)] <= needFind[S.charAt(i)])
                cnt++;
            
            if(cnt == T.length()){
                while(needFind[S.charAt(start)] == 0 || hasFind[S.charAt(start)] > needFind[S.charAt(start)]){
                    if(hasFind[S.charAt(start)] > needFind[S.charAt(start)]){
                        hasFind[S.charAt(start)]--;
                    }
                    start++;
                }
                
                if((i-start+1) < winLength){
                    winLength = i - start + 1;
                    left = start;
                    right = start + winLength;
                    win = S.substring(left, right);
                }
            }
        }
        
        return win;
    }
}