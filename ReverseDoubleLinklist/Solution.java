package ReverseDoubleLinklist;

import java.util.HashMap;

public class Solution {
	public ListNode reverse(ListNode head){
		HashMap<Integer,ListNode> mymap=new HashMap<Integer, ListNode>();
		int i=1;
		while(head!=null)
		{
			mymap.put(i, head);
			i++;
			head=head.next;
		}
		
		//System.out.println(mymap.get(2).pre.val);
		
		for(int index=1;index<mymap.size();index++)
		{
			mymap.get(index).pre=mymap.get(index+1);
			//System.out.println(mymap.get(index).pre.val);
			mymap.get(mymap.size()-index+1).next=mymap.get(mymap.size()-index);
		}
		System.out.println(mymap.get(5).next.val);
		return mymap.get(mymap.size());
	}
}
