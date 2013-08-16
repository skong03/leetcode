public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, String> mymap=new HashMap<Integer, String>();
        
        int[] num1={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuffer s=new StringBuffer();
        
        mymap.put(1,"I");
        mymap.put(4,"IV");
        mymap.put(5,"V");
        mymap.put(9,"IX");
        mymap.put(10,"X");
        mymap.put(40,"XL");
        mymap.put(50,"L");
        mymap.put(90,"XC");
        mymap.put(100,"C");
        mymap.put(400,"CD");
        mymap.put(500,"D");
        mymap.put(900,"CM");
        mymap.put(1000,"M");
        
        for(int i: num1)
        {
            while(num>=i)
            {
                s=s.append(mymap.get(i));
                num=num-i;
            }
        }
        
        return s.toString();
    }
}