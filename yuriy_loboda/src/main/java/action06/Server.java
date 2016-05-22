package action06;
//Class as likeas singleton
public class Server {
	private static Server serv;
	private static String pass="111";
	
	
	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		Server.pass = pass;
	}

	private Server(){}
	
	public static Server getInstance(){
		if(serv==null){
			serv=new Server();
		}
		return serv;
	}

}
