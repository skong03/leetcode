package bogglegame;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] table={  
			    {'f', 'x', 'i', 'e'},  
			    {'a', 'm', 'l', 'o'},  
			    {'e', 'w', 'b', 'x'},  
			    {'a', 's', 't', 'u'}  
			  };
		booglegame m=new booglegame();
		System.out.println(m.getword(table));
	}

}
