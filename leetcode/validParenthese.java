public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Character, Character> hs = new HashMap<Character, Character>();
        hs.put('(', ')');
        hs.put('[', ']');
        hs.put('{', '}');
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(hs.containsKey(s.charAt(i))) st.push(s.charAt(i));
            else if(st.isEmpty() || s.charAt(i)!=hs.get(st.pop())) return false;
        }
        return st.isEmpty();
    }
}





public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        hm.put('(', ')');
        hm.put('[', ']');
        hm.put('{', '}');
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))) st.push(s.charAt(i));
            else{
                if(st.isEmpty()) return false;
                char c = st.pop();
                if(hm.get(c) != s.charAt(i)) return false;
            }
        }
        
        return st.isEmpty();
    }
}


public class Solution {
    public boolean isValid(String s) {
    
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('[', ']');
        //map.put(']', '[');
        map.put('(', ')');
        //map.put(')', '(');
        map.put('{', '}');
        //map.put('}', '{');
    
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            else if(map.values().contains(s.charAt(i))){
                if(!stack.isEmpty() && map.get(stack.peek()) == s.charAt(i))
                    stack.pop();
                else
                    return false;
            }
        }
    
        return stack.isEmpty();
    }
}