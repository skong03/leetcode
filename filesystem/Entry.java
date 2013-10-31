package filesystem;

public abstract class Entry {
	protected Directory parent;//写代码的时候应该是什么样的逻辑，先写directory
	protected long created;
	protected long lastupdated;
	protected long lastaccss;
	protected String name;
	
	public Entry(String name){
		this.name=name;
		created=System.currentTimeMillis();
		lastupdated=System.currentTimeMillis();
		lastaccss=System.currentTimeMillis();
	}
	
	public boolean delete(){
		if(parent==null)
			return false;
		return this.parent.deleteEntry(this);
	}
	
	public void addto(Directory d){
		//this.parent=d;
		d.addEntry(this);
	}
	
	public abstract int size();//看不懂，
	
	public String getFullpath(){
		if(this.parent==null)
			return this.name;
		else return this.parent.getFullpath()+"/"+this.name;
	}
	
	public long getCreated() {
		return created;
	}
	public long getLastupdated() {
		return lastupdated;
	}
	public long getLastaccss() {
		return lastaccss;
	}
	public String getName() {
		return name;
	}
	

}
