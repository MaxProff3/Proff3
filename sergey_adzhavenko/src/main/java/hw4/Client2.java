package hw4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client2("localhost",9999).connect();
		
		while(true){		
			
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		int gottenID = dis.readInt();
		int number = dis.readInt();
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
			if(gottenID==ID)dos.writeInt(number*10);
			else dos.writeInt(-1);
		}
	}

	private final String url;
	private final int port;
	private static Socket socket;
	private final static int ID = 2;
	
	public Client2(String url, int port){
		this.url=url;
		this.port=port;
	}
	
	public void connect() throws UnknownHostException, IOException{
		socket=new Socket(url,port);
		
	}
}
