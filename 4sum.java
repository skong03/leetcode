public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(num.length<4)
            return res;
        Arrays.sort(num);
        
        for(int i=0;i<=num.length-4;i++)
        {
            for(int j=i+1;j<=num.length-3;j++)
            {
                int low=j+1;
                int high=num.length-1;
                
                while(low<high)
                {
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum>target)
                        high--;
                    else if(sum<target)
                        low++;
                    else
                    {
                        ArrayList<Integer> temp=new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[low]);
                        temp.add(num[high]);
                        if(!res.contains(temp))
                            res.add(temp);
                        low++;
                        high--;
                    }
                }
            }
        }
        
        return res;
    }
}