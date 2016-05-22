package hwWeek3;

public class Client {
	private static Client instance;
	public static int objCount = 0;
	
	private Client() {
		objCount++;
	}
	
	public static synchronized Client getInstance() {
		if(objCount < 3) {
			instance = new Client();
		}
		return instance;
	}

}
