package hw3;

public class Server {

	private static Server server;
	
	private Server(){
	}

	public static Server getInstancer(){
		if(server==null)server = new Server();
		return server;	
	}
}
