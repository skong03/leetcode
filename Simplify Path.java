public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] strs=path.split("/");
        ArrayList<String> temp=new ArrayList<String>();
        for(String s:strs){
            if(s.equals(".")||s.equals(""))//don't consider . and empty 
                continue;
            if(s.equals("..")){//remove one word from al
                if(temp.size()>0)
                    temp.remove(temp.size()-1);
            }else
                temp.add(s);
        }
        
        if(temp.size()==0)//no word in al
            return "/";
        StringBuffer sb=new StringBuffer();
        for(String s: temp){
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
}