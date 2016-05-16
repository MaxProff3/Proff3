package action06;
//реализация SingleTon
public class Server {
	private static Server instance;
	
	
	private Server () {
		
	}
	
	public static Server getInstance () {
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}

}
