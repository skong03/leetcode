public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> mymap=new HashMap<Character, Integer>();
        if(s.length()==0)
            return 0;
             
        mymap.put('I',1);
        mymap.put('V',5);
        mymap.put('X',10);
        mymap.put('L',50);
        mymap.put('C',100);
        mymap.put('D',500);
        mymap.put('M',1000);
        int current=0;
        int pre=0;
        int sum=mymap.get(s.charAt(s.length()-1));
        for(int i =s.length()-2; i>=0;i--)
        {
            current=mymap.get(s.charAt(i));
            pre=mymap.get(s.charAt(i+1));
            if(current<pre)
            {
                sum=sum-current;
            }
            else
                sum=sum+current;
        }
        
        return sum;
    }
}