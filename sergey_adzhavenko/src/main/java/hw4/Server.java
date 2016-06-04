package hw4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{

	public static void main(String[] args) {
		new Server(9999).start();
	}
	
	private static ServerSocket server;
	private final int port;
	
	public Server(int port){
		this.port=port;
		try {
			server = new ServerSocket(this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {
			while(true){
				Socket socket = server.accept();
				new ServerThread(socket).run();
			}
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
}

class ServerThread implements Runnable{
	
	private Socket socket;
	
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		while(true){
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your ID:");
			String ID = scan.next();
			System.out.println("Enter your number:");
			String number = scan.next();
			
			try {
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF(ID);
				dos.writeUTF(number);
				
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				int gottenNumber = dis.readInt();
				if(gottenNumber!=-1){
					System.out.println("Client number: "+gottenNumber);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
