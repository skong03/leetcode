public class MergeSort {
	public void sort(int[] A){
		mergeSort(A,0,A.length-1);
	}
	
	public void mergeSort(int[] A, int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			mergeSort(A,low,mid);
			mergeSort(A,mid+1,high);
			merge(A,low,mid,high);
		}
	}
	
	public void merge(int[] A, int low, int mid, int high)
	{
		int[] helper=new int[A.length];
		
		for(int i=low;i<=high;i++)
			helper[i]=A[i];
		
		int left=low;
		int right=mid+1;
		int c=low;
		
		while(left<=mid&&right<=high)
		{
			if(helper[left]<helper[right])
			{
				A[c]=helper[left];
				left++;
			}
			else
			{
				A[c]=helper[right];
				right++;
			}
			c++;
		}
		
		int remin=mid-left;
		for(int i=0;i<=remin;i++)
		{
			A[c+i]=helper[left+i];
		}
	}
}
