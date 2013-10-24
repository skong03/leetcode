//8-5-13°æ±¾£¬Î´µ÷ÊÔ
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        return recImp(start, end, dict, visited, 0);
    }
    private int recImp(String word, String end, HashSet<String> dict, HashSet<String> visited, int level){
        Set<String> levelSet = findWord(word, dict, visited);
        for(String str : levelSet){
            if(str.equals(end)) return level+1;
            level = recImp(str, end, dict, visited, level+1);
        }
        return level;
    }
    private HashSet<String> findWord(String word, HashSet<String> dict, HashSet<String> visited){
        HashSet<String> levelSet = new HashSet<String>();
        char[] chs = word.toCharArray();
        for(int i=0; i<chs.length; i++){
            char old = chs[i];
            for(char c='a'; c<='z'; c++){
                chs[i] = c;
                String str = new String(chs);
                if(!word.equals(str) && dict.contains(str) && !visited.contains(str)){
                    visited.add(str);
                    levelSet.add(str);
                }
            }
            chs[i] = old;
        }
        return levelSet;
    }
}










public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dict.add(start);
        dict.add(end);
        
        HashMap<String, ArrayList<String>> adj = new HashMap<String, ArrayList<String>>();
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        createAdj(dict, adj);
        
        LinkedList<Node> que = new LinkedList<Node>();
        HashSet<String> visited = new HashSet<String>();
        int prelevel = 0;
        
        que.add(new Node(null, 1, start));
        visited.add(start);
        
        while(!que.isEmpty()){
            Node x = que.pollFirst();
            if(end.equals(x.str)){
                if(prelevel == 0 || prelevel == x.level){
                    prelevel = x.level;
                    findPath(x, res);
                }
                //else
                    //break;
            }
            else{
                ArrayList<String> neighbors = adj.get(x.str);
                if(neighbors == null || neighbors.size() == 0)
                    continue;
                for(String s:neighbors){
                    if(!visited.contains(s)){
                        Node xp = new Node(x, x.level+1, s);
                        que.add(xp);
                        visited.add(s);
                    }
                }
            }
        }
        
        return res;
    }
    
    private void createAdj(HashSet<String> dict, HashMap<String, ArrayList<String>> adj){
        for(String str:dict){
            char[] chs = str.toCharArray();
            for(int i=0; i<str.length(); i++){
                char pre = chs[i];
                for(char c='a'; c<='z'; c++){
                    chs[i] = c;
                    String newstr = new String(chs);
                    if(c == pre || !dict.contains(newstr))
                        continue;
                    ArrayList<String> neighbors = adj.get(str);
                    if(neighbors == null){
                        neighbors = new ArrayList<String>();
                        neighbors.add(newstr);
                        adj.put(str, neighbors);
                    }                    
                    else{
                        neighbors.add(newstr);
                    }
                }
                chs[i] = pre;
            }
        }
    }
    
    private void findPath(Node x, ArrayList<ArrayList<String>> res){
        ArrayList<String> path = new ArrayList<String>();
        while(x != null){
            path.add(0, x.str);
            x = x.parent;
        }
        res.add(path);
    }
    
    private class Node{
            Node parent;
            int level;
            String str;
            
            public Node(Node parent, int level, String str){
                this.parent = parent;
                this.level = level;
                this.str = str;
            }
        }
}












public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dict.add(start);
        dict.add(end);
        
        HashMap<String, HashSet<String>> adj = new HashMap<String, HashSet<String>>();
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        createAdj(dict, adj);
        
        LinkedList<Node> que = new LinkedList<Node>();
        // HashSet<String> visited = new HashSet<String>();
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
        int prelevel = 0;
        
        que.add(new Node(null, 1, start));
        // visited.add(start);
        
        while(!que.isEmpty()){
            Node x = que.pollFirst();
            if(end.equals(x.str)){
                if(prelevel == 0 || prelevel == x.level){
                    prelevel = x.level;
                    findPath(x, res);
                }
                else
                    break;
            }
            else{
                HashSet<String> neighbors = adj.get(x.str);
                if(neighbors == null || neighbors.size() == 0)
                    continue;
                ArrayList<String> toRemove = new ArrayList<String>();
                
                for(String s:neighbors){
                    if(visited.containsKey(s)){
                        Integer occurLevel = visited.get(s);
                        if(x.level+1 > occurLevel){
                            adj.get(s).remove(x.str);
                            toRemove.add(s);
                            continue;
                        }
                    }
                    visited.put(s, x.level+1);
                    que.add(new Node(x, x.level+1, s));
                    if(adj.containsKey(s))
                        adj.get(s).remove(x.str);
                }
                for(String s:toRemove)
                    neighbors.remove(s);
            }
        }
        
        return res;
    }
    
    private void createAdj(HashSet<String> dict, HashMap<String, HashSet<String>> adj){
        for(String str:dict){
            char[] chs = str.toCharArray();
            for(int i=0; i<str.length(); i++){
                char pre = chs[i];
                for(char c='a'; c<='z'; c++){
                    chs[i] = c;
                    String newstr = new String(chs);
                    if(c == pre || !dict.contains(newstr))
                        continue;
                    HashSet<String> neighbors = adj.get(str);
                    if(neighbors == null){
                        neighbors = new HashSet<String>();
                        neighbors.add(newstr);
                        adj.put(str, neighbors);
                    }                    
                    else{
                        neighbors.add(newstr);
                    }
                }
                chs[i] = pre;
            }
        }
    }
    
    private void findPath(Node x, ArrayList<ArrayList<String>> res){
        ArrayList<String> path = new ArrayList<String>();
        while(x != null){
            path.add(0, x.str);
            x = x.parent;
        }
        res.add(path);
    }
    
    private class Node{
            Node parent;
            int level;
            String str;
            
            public Node(Node parent, int level, String str){
                this.parent = parent;
                this.level = level;
                this.str = str;
            }
        }
}




















