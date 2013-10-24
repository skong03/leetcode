public class QuickSort {
public void sort(int[] A){
		quicksort(A,0,A.length-1);
	}
	
	public void quicksort(int[] A, int left, int right)
	{
		int index=partition(A,left,right); //index=pivot's position
		if(left<index-1)//if(left<pivot's position) this array has unsort left part,need to be sorted
			quicksort(A,left,index-1);
		if(index<right)//same to the right part
			quicksort(A,index,right);
	}
	
	public int partition(int[] A, int left, int right)
	{
		int pivot=A[(left+right)/2];
		while(left<right)
		{
			while(A[left]<pivot)
				left++;
			while(A[right]>pivot)
				right--;
			
			if(left<=right)
			{
				int temp=A[left];
				A[left]=A[right];
				A[right]=temp;
				left++;
				right--;
			}
		}
		return left;
	}
}
