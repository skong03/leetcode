public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> st = new Stack<Integer>();
        int start = -1;
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                if(st.isEmpty()){
                    start = i;
                }
                else{
                    st.pop();
                    if(st.isEmpty())
                        res = Math.max(res, i-start);
                    else
                        res = Math.max(res, i-st.peek());
                }
            }
        }
        
        return res;
    }
}