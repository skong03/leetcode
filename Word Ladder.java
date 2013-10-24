public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> visit=new HashSet<String>();
        LinkedList<String> q=new LinkedList<String>();
        q.add(start);
	visit.add(start);
        int cur=1;
        int next=0;
        int count=0;
        while(!q.isEmpty()){
            String temp=q.remove(0);
            cur--;
            for(String s:onebit(temp)){
                if(s.equals(end)){
                    return count+2;
                }
                if(dict.contains(s)&&!visit.contains(s)){
                    visit.add(s);
                    q.add(s);
                    next++;
                }
            }
            if(q.isEmpty())//disconnect
                return 0;
            if(cur==0){
                count++;
                cur=next;
                next=0;
            }
        }
        return count;
    }
    public HashSet<String> onebit(String s){
        HashSet<String> result=new HashSet<String>();
        char[] word=s.toCharArray();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            for(char c='a';c<='z';c++){
                if(temp!=c){
                    word[i]=c;
                    result.add(new String(word));
                }
            }
            word[i]=temp;
        }
        return result;
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