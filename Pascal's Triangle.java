public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        int[][] table=new int[numRows][numRows];
        
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                {
                    table[i][j]=1;
                    temp.add(1);
                }
                else
                {
                    table[i][j]=table[i-1][j-1]+table[i-1][j];
                    temp.add(table[i][j]);
                }
            }
            res.add(temp);
        }
        return res;
        
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(numRows==0)
            return res;
        ArrayList<Integer> pre=new ArrayList<Integer>();
        pre.add(1);
        res.add(new ArrayList<Integer>(pre));
        ArrayList<Integer> cur=new ArrayList<Integer>();
        for(int i=1;i<numRows;i++){
            cur.add(1);
            for(int j=1;j<pre.size();j++){
                cur.add(pre.get(j-1)+pre.get(j));
            }
            cur.add(1);
            res.add(cur);
            pre=cur;
            cur=new ArrayList<Integer>();
        }
        return res;
    }
}