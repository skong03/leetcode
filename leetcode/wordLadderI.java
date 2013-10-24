//练习版
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        visited.add(start);
        q.add(start);
        int size = q.size(), cnt = 0;
        int res = 1;
        while(!q.isEmpty()){
            String word = q.poll();
            cnt++;
            for(String str : getWord(word, dict, visited)){
                if(str.equals(end)) return res+1;
                else q.add(str);
            }
            if(cnt == size){
                size = q.size();
                cnt = 0;
                res++;
            }
        }
        return 0;
    }
    private HashSet<String> getWord(String word, HashSet<String> dict, HashSet<String> visited){
        HashSet<String> levelSet = new HashSet<String>();
        for(int i=0; i<word.length(); i++){
            char[] chs = word.toCharArray();
            for(char c='a'; c<='z'; c++){
                chs[i] = c;
                String tmp = new String(chs);
                if(!word.equals(tmp) && dict.contains(tmp) && !visited.contains(tmp)){
                    visited.add(tmp);
                    levelSet.add(tmp);
                }
            }
        }
        return levelSet;
    }
}









//第二版
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 1;
        HashSet<String> visited = new HashSet<String>();
        LinkedList<String> q = new LinkedList<String>();
        q.add(start);
        visited.add(start);
        int sum = 1, cnt = 0;
        
        while(!q.isEmpty()){
            String x = q.poll();
            cnt++;
            for(String e : getAllPerm(x)){
                if(e.equals(end)) return res+1;
                if(dict.contains(e) && !visited.contains(e)){
                    q.add(e);
                    visited.add(e);
                }
            }
            if(cnt == sum){
                res++;
                cnt = 0;
                sum = q.size();
            }
        }
        
        return res;
    }
    
    private HashSet<String> getAllPerm(String s){
        HashSet<String> hs = new HashSet<String>();
        for(int i=0; i<s.length(); i++){
            char[] chs = s.toCharArray();
            for(char ch='a'; ch<='z'; ch++){
                chs[i] = ch;
                hs.add(new String(chs));
            }
        }
        return hs;
    }
}


//第一版
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dict.add(start);
        dict.add(end);
        
        HashMap<String, ArrayList<String>> ht = new HashMap<String, ArrayList<String>>();
        
        for(String str:dict){
            char[] chs = str.toCharArray();
            for(int i=0; i<str.length(); i++){
                char pre = chs[i];
                for(char c='a'; c<='z'; c++){
                    chs[i] = c;
                    String newstr = new String(chs);
                    if(!dict.contains(newstr) || newstr.equals(str))
                        continue;
                    ArrayList<String> neighbors = ht.get(str);
                    if(neighbors == null){
                        neighbors = new ArrayList<String>();
                        neighbors.add(newstr);
                        ht.put(str, neighbors);
                    }
                    else{
                        neighbors.add(newstr);
                    }
                }
                chs[i] = pre;
            }            
        }
        
        LinkedList<Node> q = new LinkedList<Node>();
        HashSet<String> visited = new HashSet<String>();
        Node n = new Node(1, start);
        q.add(n);
        visited.add(start);
        int res = 0;
        
        while(!q.isEmpty()){
            Node x = q.pollFirst();
            if(x.str.equals(end)){
                res = x.level;
                break;
            }
            ArrayList<String> neighbors = ht.get(x.str);
            if(neighbors == null || neighbors.size() == 0)
                continue;
            for(String s:neighbors){
                if(!visited.contains(s)){
                    Node x2 = new Node(x.level+1, s);
                    q.add(x2);
                    visited.add(s);
                }
            }
        }
        
        return res;
    }
    
    private class Node{
        int level;
        String str;
        
        public Node(int level, String str){
            this.level = level;
            this.str = str;
        }
    }
}