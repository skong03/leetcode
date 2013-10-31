package Hanoi;


public class tower {
	mystack s1, s2, s3;
	int number;
	public tower(int n)
	{
		s1=new mystack("s1");
		s2=new mystack("s2");
		s3=new mystack("s3");
		for(int i=n;i>0;i--)
			s1.push(i);
		number=n;
	}
	
	public void solve()
	{
		move(number,s1,s3,s2);
	}
	
	public void move(int num, mystack original, mystack destination, mystack buffer)
	{
		if(num==0)
			return;
		else{
			move(num-1,original,buffer,destination);
			moveone(original, destination);
			move(num-1,buffer,destination,original);
			}
	}
	
	public void moveone(mystack s1, mystack s2)
	{
		System.out.println("move form "+s1.name+" to "+ s2.name);
		int a=s1.pop();
		s2.push(a);
	}
}
