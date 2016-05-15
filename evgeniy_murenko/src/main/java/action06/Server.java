package action06;

public class Server {
	
	private static Server serv;
	
	private Server(){}
	
	public Server getInstance(){
		if (serv == null){
			serv = new Server();
		}
		return serv;
	}

}
