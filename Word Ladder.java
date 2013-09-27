public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> myset = new ArrayList<String>();
		myset.add(start);
		dict.remove(start);
		int count = 0;

		while (!myset.isEmpty()) {
			ArrayList<String> next = new ArrayList<String>();
			count++;
			while (!myset.isEmpty()) {
				String temp = myset.remove(0);
				if (adj(temp, end)) {
					return count+1;
				}
				for (String s : dict) {
	
					if (adj(temp, s)) {
						next.add(s);
					}
				}
				for (String i : next) {
					dict.remove(i);
				}
			}
			myset = next;
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



public class Solution {
    int count;
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        count=0;
        HashMap<String, Integer> v=new HashMap<String, Integer>();
        LinkedList<String> q=new LinkedList<String>();
        int cur=0;
        int next=0;
        q.add(start);
        cur++;
        
        while(!q.isEmpty())
        {
            String str=q.removeFirst();
            if(adj(str,end))
                return count+2;
            cur--;
            for(String s:dict)
            {
                if(!v.containsKey(s)&&adj(s,str))
                {    
                    q.add(s);
                    next++;
                    v.put(s,0);
                }
            }
            
            if(cur==0)
            {
                count++;
                cur=next;
                next=0;
            }
        }
        return 0;
    }
   
    
    public boolean adj(String a, String b)
    {
        int count=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
                count++;
        }
        if(count==1)
            return true;
        else 
            return false;
    }
}