public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0)
            return 0;
        char[] mychar= s.toCharArray();
        return dfs(0,mychar);
    }
    
    public int dfs(int index, char[] mychar)
    {
        if(index < mychar.length && mychar[index]=='0')
            return 0;
        else if(index==mychar.length-1||index==mychar.length)
            return 1;
        //else if(mychar[index]=='1'&& mychar[index+1]=='0')
            //return dfs(index+2,mychar);
        else if(mychar[index]=='1'||(mychar[index]=='2'&&mychar[index+1]<='6'))
            return dfs(index+1, mychar)+dfs(index+2,mychar);
        else
            return dfs(index+1,mychar);
    }
}


/*ÒÔÏÂÓÐbug*/
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0||s.equals("0")||s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;
            
        int p1=s.length()-1;
        int[] num=new int[s.length()];
        
        //if(s.charAt(p1)=='0')
            //num[p1]=0;
        //else 
        num[s.length()-1]=1;
        
        for(int p2=p1-1;p2>=0;p2--)
        {
            if(s.charAt(p2+1)=='0'&&s.charAt(p2)=='0')
        		return 0;
        	else if(s.charAt(p2+1)=='0')
            {num[p2]=num[p1];p2--;}
            else if(s.charAt(p2)=='1'||(s.charAt(p2)=='2'&&s.charAt(p2+1)>='1'&&s.charAt(p2+1)<='6'))
                num[p2]=num[p2+1]+1;
            else 
                num[p2]=num[p2+1];
        }
        
        return num[0];
    }
}