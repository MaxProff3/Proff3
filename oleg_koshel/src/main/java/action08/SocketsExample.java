package action08;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class SocketsExample {
	public static void main(String[] args) {
		int port = 3235;
		new Server(port).start();
		new Client("localhost", port).connect();
		
	}

}

class Server extends Thread{
	private ServerSocket server;
	private final int port;

	public Server(int p) {
		port = p;
	}
	@Override
	public void run() {
		try {
			server = new ServerSocket(port);
			System.out.println("Server is started!");
			while (true) {
				Socket socket = server.accept(); // слушатель
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
			System.out.println("Client is connect");
			
			//InputStream is = socket.getInputStream();
			//DataInputStream dis = new DataInputStream(is);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeUTF("Hello server");
			//String str = dis.readUTF();
			System.out.println("Server write");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerForClients extends Thread {
	private Socket socket;
	private ServerForClients sfc;

	public ServerForClients(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			String str = dis.readUTF();
			System.out.println(str);
			dos.writeUTF("qqqq");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}