public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
        HashSet<String> visit=new HashSet<String>();
        LinkedList<String> q=new LinkedList<String>();
        HashMap<String, String> table=new HashMap<String,String>();
        q.add(start);
        int cur=1;
        int next=0;
        visit.add(start);
        while(!q.isEmpty())
        {
            String temp=q.remove(0);
            cur--;
            //System.out.println(edit(temp));
            for(String v:edit(temp))
            {
                if(v.equals(end)){
                	//table.put(end, temp);
                	System.out.println("table: "+table);
                    for(String s:edit(end)){                  
                    	if(table.size()==0)
                    	{
                    		ArrayList<String> pp=new ArrayList<String>();
                    		pp.add(start);
                    		pp.add(end);
                    		res.add(pp);
                    		return res;
                    	}
                        if(table.containsKey(s)){                        	
                            ArrayList<String> list=new ArrayList<String>();
                            list.add(0,end);
                            String back=s;
                            while(back!=start){
                            	//System.out.println(s);
                                list.add(0,back);
                                back=table.get(back);
                            }
                            list.add(0,start);
                            res.add(list);
                        }
                    }
                    return res;
                }
                else if(dict.contains(v)&&!visit.contains(v)){
                        q.add(v);
                        visit.add(v);
                        table.put(v,temp);
                        next++;
                }
                //System.out.println("s");
            }
            if(q.isEmpty())
                return null;
            if(cur==0)
            {
                cur=next;
                next=0;
            }
        }
        return res;
    }
    
    public HashSet<String> edit(String s){
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