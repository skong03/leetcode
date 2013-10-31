package filesystem;

public class file extends Entry{
	private String contets;
	private int size;
	
	public file(String name,  int sz){
		super(name);
		size=sz;
	}
	
	public int size(){
		return size;
	}
	public String getcontets(){return contets;}
	public void setconts(String c){contets=c;}
}
