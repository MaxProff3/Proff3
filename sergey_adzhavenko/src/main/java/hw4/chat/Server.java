package hw4.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javafx.scene.control.TextArea;

public class Server extends Thread{

	private static ServerSocket server;
	private final int port;
	private static TextArea chatWindow = new TextArea();
	private static ArrayList<ServerThread> threadList = new ArrayList<>();
	
	public Server(int port){
		this.port=port;
		try {
			server=new ServerSocket(this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true){
			try {
				Socket socket = server.accept();
				ServerThread serverThread = new ServerThread(socket);
				threadList.add(serverThread);
				serverThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized static ArrayList<ServerThread> getThreadList() {
		return threadList;
	}

	public static TextArea getChatWindow() {
		return chatWindow;
	}
}

class ServerThread extends Thread{

	private Socket socket;
	private String lastMessage;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try{
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(Server.getChatWindow().getText());		
		}catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			try {
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				lastMessage=dis.readUTF();
				Server.getChatWindow().appendText(lastMessage+"\n");
					for(int i=0;i<Server.getThreadList().size();i++){
						OutputStream os = Server.getThreadList().get(i).socket.getOutputStream();
						DataOutputStream dos = new DataOutputStream(os);
						dos.writeUTF(lastMessage);
					}					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
