public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] my=s.toCharArray();
        
        if(my.length%2==1)
            return false;
            
        Stack<Character> p=new Stack<Character>();
        
        for(int i=0; i<my.length;i++)
        {
            if(my[i]=='('||my[i]=='['||my[i]=='{')
                p.push(my[i]);
            else if(my[i]==')' && p.size()!=0 && p.peek()=='(')
                p.pop();
            else if(my[i]==']' && p.size()!=0 && p.peek()=='[')
                p.pop();
            else if(my[i]=='}' && p.size()!=0 && p.peek()=='{')
                p.pop();
            else
                return false;
        }
        
        if(p.size()!=0)
            return false;
        return true;
    }
}