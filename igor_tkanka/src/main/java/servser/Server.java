package servser;

public class Server {

	private static Server server;
	private int port;
	
	public Server getInstanse(){
		
		if (server==null) {
			server=new Server();
		}
		
		return server;
	}
	
	private Server(){
		
		port=8080;
		
	}
	
}
