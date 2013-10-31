package heap;

public class heap {
	int[] h;
	heap(int n){
		h=new int[n];
		for(int i=0;i<n;i++){
			h[i]=(int)(Math.random()*n);
			System.out.print(h[i]+"  ");
		}
	}
	
	public void buildheap(){
		for(int i=h.length/2-1;i>=0;i--)
			Max_heapfiy(i);
	}
	private void Max_heapfiy(int index){
		int l=index*2+1;
		int r=index*2+2;
		int newindex=index;//compare the h[index] and it's children, find out the smaller child, change position, then heapfy the child.
		if(l<h.length&&h[newindex]<h[l]){
			newindex=l;
		}
		
		if(r<h.length&&h[newindex]<h[r]){
			newindex=r;
		}
		
		if(index!=newindex){
			swap(h,index,newindex);
			Max_heapfiy(newindex);
		}
	}
	
	public void heapsort(){
		for(int i=h.length-1;i>=0;i--){
			Max_heapfiy(0);
			System.out.print(h[0]+"  ");
			swap(h,i,1);
			h[i]=Integer.MIN_VALUE;
		}
	}

	public void print(){
		for(int i:h){
			System.out.print(i+"  ");
		}
	}
	public void swap(int[] A, int i, int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
}
