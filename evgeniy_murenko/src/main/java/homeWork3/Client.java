package homeWork3;

public class Client {
	private static Client[] clients = new Client[3];

	private Client() {
	}

	private static int isFree() {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				return i;
			}
		}
		return -1;
	}

	public static Client getInstance() {
		int index = isFree();
		if (index > -1) {
			clients[index] = new Client();
			return clients[index];
		} else {
			System.out.println("All is busy");
			return null;
		}
		
	}

}
