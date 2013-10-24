
class Que<Item>{
	Node head;
	Node tail;
	
	public Que(){
		head = null;
		tail = null;
	}
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
			next = null;
		}
	}
	
	public void enque(Item item){
		Node x = new Node(item);
		if(isEmpty()){
			head = x;
			tail = x;
			return;
		}
		tail.next = x;
		tail = x;
	}
	
	public Item deque(){
		if(isEmpty())
			return null;
		Node tmp = head;
		head = head.next;
		return tmp.item;
	}
	
	public Item peek(){
		return head.item;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
}