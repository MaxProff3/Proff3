package action08Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketsExample {
	public static void main(String[] args) {
		int port = 61610;
		new Server(port).start();
		new Client("localhost", port).connect();
	}
}

class Server extends Thread {
	private ServerSocket server;
	private final int port;

	public Server(int p) {
		port = p;
	}

	public void run() {

		try {
			server = new ServerSocket(port);
			System.out.println("Server is started!");
			while (true) {
				Socket socket = server.accept();
				new ServerForClients(socket).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Client {
	private String url;
	private int port;
	private Socket socket;

	public Client(String url, int port) {
		this.url = url;
		this.port = port;
	}

	public void connect() {
		try {
			socket = new Socket(url, port);
			// InputStream is = socket.getInputStream();
			// DataInputStream dis = new DataInputStream(is);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			while (true)
				dos.writeUTF("Hello server1");
			// String str = dis.readUTF();
			// System.out.println("Client receive from srever:" + str);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerForClients extends Thread {
	private Socket socket;

	public ServerForClients(Socket s) {
		socket = s;

	}

	@Override
	public void run() {

		try {
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			// OutputStream os = socket.getOutputStream();
			// DataOutputStream dos = new DataOutputStream(os);
			while (true) {
				System.out.println("server: " + dis.readUTF());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}