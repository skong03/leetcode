public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> al = new ArrayList<String>();
        String[] part = path.split("/");
        
        for(String str : part){
            if(str.length() == 0 || str.equals("."))
                continue;
            else if(str.equals("..")){
                if(al.size() > 0)
                    al.remove(al.size()-1);
            }
            else
                al.add(str);
        }
        
        
        
        if(al.size() == 0)
            return "/";
        
        StringBuilder sb = new StringBuilder();
        for(String str : al){
            sb.append("/");
            sb.append(str);
        }
        
        return sb.toString();
    }
}