package filesystem;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directory one =new Directory("one");
		Directory two=new Directory("two");
		Directory three=new Directory("three");
		one.addEntry(two);
		one.addEntry(three);
		
		file file2=new file("file2",11);
		//one.addEntry(file2);
		file2.addto(one);
		//file2.delete();
		file file1=new file("file1",10);
		two.addEntry(file1);
		
		//one.print();
		//System.out.println(one.number());
		//System.out.println(file1.getFullpath());
		System.out.println(one.size());
		
		
		
	}

}
