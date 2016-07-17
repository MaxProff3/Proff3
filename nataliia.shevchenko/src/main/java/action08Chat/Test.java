package action08Chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {

		try {
			Socket s = new Socket("127.0.0.1", 33387);
			System.out.println(s.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
