package HashMap;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> table=new HashMap<String, String>();
		table.put("1", "ksk");
		table.put("2", "jack");
		table.put("3", "ooo");
		table.put("4","sd5");
		table.put("14","sd");
		table.put("24","sd1");
		table.put("43","sd2");
		table.put("24","sd3");
		
		System.out.println(table.get("24"));
	}

}
