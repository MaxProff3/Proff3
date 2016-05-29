package hw4.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TextArea;

public class Client extends Thread {

	private final int port;
	private static Socket socket;
	private TextArea chat = new TextArea();

	public Client(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				getChat().appendText(dis.readUTF()+"\n");
			} catch (IOException e) {
			}
		}
	}

	public void send(Message m){
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(m.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TextArea getChat() {
		return chat;
	}

	public void setChat(TextArea chat) {
		this.chat = chat;
	}
	
}

class Message {
	private String message;
	private final static SimpleDateFormat formatDate1 = new SimpleDateFormat("dd.MM.yyyy");
	private final static SimpleDateFormat formatTime2 = new SimpleDateFormat("hh:mm:ss");

	public Message(String name, String text) {
		this.message = "<"+formatDate1.format(new Date()) + " at " + formatTime2.format(new Date()) + ">\n" + name + ": "
				+ text;
	}

	public String getMessage() {
		return message;
	}

}
