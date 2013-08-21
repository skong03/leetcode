import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //dict.add(end);
        ArrayList<String> myset=new ArrayList<String>();
        myset.add(start);
        dict.remove(start);
        //System.out.println(dict);
        int count=0;
        while(!myset.isEmpty() && !dict.isEmpty())
        {
        	System.out.println("dic"+dict);
        	System.out.println("myset:"+myset);
        	count++;
        	String temp=myset.remove(0);
        	if(adj(temp,end))
        		{
        				return count;
    			}
        	
        
        	for(String s : dict)
            {
        		//System.out.println(s);
        		if(adj(temp, s))
            	{
            		myset.add(s);
            	}
            }
        	
        	for(String i :myset)
        	{
        		dict.remove(i);
        	}
        }
        return 0;
    }
    
    public boolean adj(String a, String b)
    {
    	int count=0;
    	for(int i=0; i<a.length();i++)
    	{
    		if(a.charAt(i)!=b.charAt(i))
    			count++;
    	}
    	if(count==1)
			return true;
    	return false;
    }
}