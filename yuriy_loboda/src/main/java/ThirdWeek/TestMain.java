package ThirdWeek;

public class TestMain {
	public static void main(String[] args) {
		Server srv1 = Server.getInstance();
		Server srv2 = Server.getInstance();
		srv1.setPass("777");
		System.out.println(srv2.getPass());
	
		
		
	}
	
	
	

}
