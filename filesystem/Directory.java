package filesystem;

import java.util.ArrayList;

public class Directory extends Entry {
	protected ArrayList<Entry> contents;
	
	public Directory(String name){
		super(name);//Entry(n,p)
		contents=new ArrayList<Entry>();
	}
	
	public int size(){
		int size=0;
		for(Entry e:contents)
		{
			size+=e.size();//
		}
		return size;
	}
	
	public int number(){
		int count=0;
		for(Entry e:contents)
		{
			if(e instanceof Directory)
			{
				count++;
				Directory d=(Directory)e;
				count+=d.number();
			}
			else if(e instanceof file)
			{
				count++;
			}
		}
		return count;
	}
	
	public boolean deleteEntry(Entry e){
		return contents.remove(e);
	}
	public void addEntry(Entry entry){
		entry.parent=this;
		contents.add(entry);
	}
	
	protected ArrayList<Entry> getcon(){
		return contents;
	}
	
	public void print(){
		for(Entry e:contents)
		{
			System.out.println(e.name);
		}
	}
	

}
