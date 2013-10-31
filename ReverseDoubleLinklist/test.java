package ReverseDoubleLinklist;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(2);
		ListNode a3=new ListNode(3);
		ListNode a4=new ListNode(4);
		ListNode a5=new ListNode(5);
		
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		a4.next=a5;
		
		a2.pre=a1;
		a3.pre=a2;
		a4.pre=a3;
		a5.pre=a4;
//		while(a1!=null)
//		{System.out.println(a1.val);
//		a1=a1.next;}
 		Solution m=new Solution();
		
		ListNode res=m.reverse(a1);
		
//		while(res!=null)
//		{System.out.println(res.val);
//		res=res.next;}
	}

}
