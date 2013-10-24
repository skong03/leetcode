public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.length()!=end.length()) return 0;
        if (start.length()==0||end.length()==0) return 1;
        if (dict.size()==0) return 0;
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visit = new HashSet<String>();
        queue.add(start);
        visit.add(start);
        while(!queue.isEmpty()){
            String w = queue.poll();
            curNum--;
            for(String v:getOneEditWords(w)){
                if (v.equals(end)){
                    return level+1;
                }
                if (dict.contains(v)){
                    if (!visit.contains(v)){
                        queue.add(v);
                        nextNum++;
                        visit.add(v);
                    }
                }
            }
            if (curNum==0) {
                level++;
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return 0;
    }
    public Set<String> getOneEditWords(String word){
        Set<String> words = new HashSet<String>();
        for (int i=0;i<word.length();i++){
            char[] wordArray = word.toCharArray();   // This statement should be within the first loop
            for(char c='a';c<='z';c++){
                if (c!=word.charAt(i)){
                    wordArray[i] = c;
                    words.add(new String(wordArray));
                }
            }
        }
        return words;
    }
}