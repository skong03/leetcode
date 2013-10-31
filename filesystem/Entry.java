package filesystem;

public abstract class Entry {
	protected Directory parent;//д�����ʱ��Ӧ����ʲô�����߼�����дdirectory
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
	
	public abstract int size();//��������
	
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
