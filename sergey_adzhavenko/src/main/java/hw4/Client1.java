package hw4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client1("localhost",9999).connect();
		
		while(true){		
			
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		int gottenID = Integer.parseInt(dis.readUTF());
		int number = Integer.parseInt(dis.readUTF());
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
			if(gottenID==ID)dos.writeInt(number*2);
			else dos.writeInt(-1);
		}
	}

	private final String url;
	private final int port;
	private static Socket socket;
	private final static int ID = 1;
	
	public Client1(String url, int port){
		this.url=url;
		this.port=port;
	}
	
	public void connect() throws UnknownHostException, IOException{
		socket=new Socket(url,port);
		
	}
}

