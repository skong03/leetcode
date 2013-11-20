public class Solution{
public ArrayList<String> fullJustify(String[] words, int L) {
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    int cur = 0;
    int len = 0;

    while (cur < words.length) {
        sb.setLength(0);
        sb.append(words[cur]);

        list.clear();
        len = words[cur].length();
        //list.add(words[cur]);
        cur++;

        while (cur<words.length && len + 1 + words[cur].length() <= L) {
            list.add(" " + words[cur]);
            len += words[cur].length() + 1;
            cur++;
        }

        if (cur < words.length && list.size() > 0) {
            int spaces = L - len;
            int avg = spaces / list.size();
            int rem = spaces % list.size();
            for (int i=0; i<list.size(); i++) {
                appendSpaces(sb, i<rem? avg+1 : avg);
                sb.append(list.get(i));
            }
        }
        else {
            for (int i=0; i<list.size(); i++) sb.append(list.get(i));
            appendSpaces(sb, L - len);
        }

        res.add(sb.toString());
    }
    return res;
}

private void appendSpaces(StringBuilder sb, int n) {
    for (int i=0; i<n; i++) sb.append(' ');
}
}



public class Solution {
	public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res=new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            int num=L;
            ArrayList<String> temp=new ArrayList<String>();
            while(i<words.length&&num>=words[i].length()){
                temp.add(words[i]);
                num=num-words[i].length()-1;
                i++;
            }
            i--;
            //System.out.println(temp);
            if(i==words.length-1)
                res.add(getlast(temp,L));
            else
                res.add(getline(temp,L));
        }
        return res;
    }
    
    public String getlast(ArrayList<String> al,int L){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<al.size()-1;i++){
            sb.append(al.get(i));
            sb.append(" ");
            L=L-al.get(i).length()-1;
        }
        sb.append(al.get(al.size()-1));
        L=L-al.get(al.size()-1).length();
        for(int i=0;i<L;i++)
        	sb.append(" ");
        return sb.toString();
    }
	public String getline(ArrayList<String> al, int l){
        StringBuffer sb=new StringBuffer();
        int space=0;
        if(al.size()==1){//if only one word in line, put it in the mid
            space=l-al.get(0).length();
            //int left=(space+1)/2;
            //int right=space-left;
            //for(int i=0;i<left;i++)
                //sb.append(" ");
            sb.append(al.get(0));
            for(int i=0;i<space;i++)
                sb.append(" ");
            return sb.toString();
        }
        //more than one word
        int count=0;
        int sumlength=0;
        for(String s: al){
            count++;
            sumlength+=s.length();
        }
        //System.out.println(sumlength);
        
        space=l-sumlength;
        int base=space/(count-1);
        int bounes=space%(count-1);
        
        for(int i=0;i<al.size()-1;i++){
            sb.append(al.get(i));
            for(int j=0;j<base;j++){
                sb.append(" ");
            }
            if(bounes>0){
                sb.append(" ");
                bounes--;
            }
        }
        sb.append(al.get(al.size()-1));
        return sb.toString();
    }
}
