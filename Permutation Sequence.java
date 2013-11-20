public class Solution {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0 || k == 0)
			return null;
		int[] cnt = new int[n + 1];
		cnt[0] = 1;
		for (int i = 1; i <= n; i++) {
			cnt[i] = cnt[i - 1] * i;
		}
		cnt[0] = 1;
		if (k > cnt[n])
			return null;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		return getPermutations(nums, cnt, n, k);
	}

	public String getPermutations(int[] nums, int[] cnt, int n, int k) {
		if (n == 0)
			return "";
		for (int i = 1; i <= n; i++) {
			if (k <= cnt[n - 1] * i) {
				int t = nums[i - 1];
				for (int j = i - 1; j < n - 1; j++) {
					nums[j] = nums[j + 1];
				}
				return Integer.toString(t) + getPermutations(nums, cnt, n - 1, k - cnt[n - 1] * (i - 1));
			}
		}
		return "";
	}
}

//use nextPermutation to solove the problem
public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<int[]> table=new ArrayList<int[]>();
        int[] first=new int[n];
        for(int i=0;i<n;i++){
            first[i]=i+1;
        }
        table.add(first);
        int[] num=first;
        for(int i=1;i<k;i++){
            nextPermutation(num);
            table.add(num);
            num=new int[n];
            num=table.get(i);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<num.length;i++){
            sb.append(num[i]);
        }
        return sb.toString();
    }
    
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=num.length-1;
        for(;index>=1;index--)//find the first number which pre is smaller than cur
        {
            if(num[index-1]>=num[index])
                continue;
            else
                break;
        }
        
        reverse(num, index, num.length-1);//reverse it
        
        int pre=index-1;
        for(;index<=num.length-1;index++) //be care for the the"="
        {
            if(pre>=0&&num[pre]<num[index])//be care for the the "=" can't understand
            {
                swap(num, pre, index);
                break;
            }
        }
        
    }
    
    public void reverse(int[] num, int low, int high)
    {
        while(low<high)
        {
            swap(num, low, high);
            low++;
            high--;
        }
    }
    
    public void swap(int[] num, int a, int b)
    {
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
}