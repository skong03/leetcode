public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        if(num.length<3)
            return res;
    
        for(int i=0; i<num.length-2;i++)
        {
            int p1=i+1;
            int p2=num.length-1;
            
            while(p1<p2)
            {
                if(num[p1]+num[i]+num[p2]==0)
                {
                    ArrayList<Integer> temp= new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[p1]);
                    temp.add(num[p2]);
                    if(!res.contains(temp))
                        res.add(temp);
                    p2--;
                    p1++;
                }
                else if(num[p1]+num[i]+num[p2]>0)
                {
                    p2--;
                }
                else 
                {
                    p1++;
                }
            }
        }
        return res;
    }
}