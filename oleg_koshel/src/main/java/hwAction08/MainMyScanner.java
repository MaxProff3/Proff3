package hwAction08;

public class MainMyScanner {
	
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		
		while (sc.hasNextInt()){
			
			System.out.println(sc.nextInt());
			
		}
		
	}

}
