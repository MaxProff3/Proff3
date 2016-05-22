package action08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketsExample {
	public static void main(String[] args) {
		int port = 3235;
		new Server(port).start();// if system display notification that port is busy or not available, 
		// then select another port
		new Client("localhost", 3235).connect();
	}

}

class Server {
	private ServerSocket server;
	private final int port;

	public Server(int p) {
		port = p;
	}

	public void start(){
		try{
			server = new ServerSocket(port);
			while(true){
				Socket socket = server.accept();
				new 
			}
		}
	}
}

class Client {
	private String url;
	private Integer port;
	private Socket socket;

	public Client(String url, int port) {
		this.url = url;
		this.port = port;
	}

	public void connect(){
		try{
			socket = new Socket(url, port);
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataInputStream(os);
		
		}catch (){
			
		}
	}

}

class ServerForClients extends Thread {
	private Socket socket;

	public ServerForClients(Socket s) {
		socket = s;
	}

}