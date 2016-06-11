package FourthWeek;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Master extends Application{
	private int port;
	private ServerSocket server;
	private TextArea chat;
	
	public TextArea getChat() {
		return chat;
	}

	public void setChat(TextArea chat) {
		this.chat = chat;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("CHAT");
		stage.setScene(createScene());
		stage.show();
		
	}

	private Scene createScene() {
		new StartMaster(3230,this).start();
		VBox gp=new VBox();	
		 chat=new TextArea();	
		 
		
		gp.getChildren().add(chat);
		
		Scene scene = new Scene(gp, 500 , 300);
		return scene;
	}


}
class StartMaster extends Thread{
	private int port;
	private ServerSocket server;
	private Master master;
	
	public StartMaster(int port,Master master){
		this.port=port;
		this.master=master;
	}
	@Override
	public void run(){
		try {
			server=new ServerSocket(port);
			while(true){
			Socket socket = server.accept();
			new MasterActivity(socket,master).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
class MasterActivity extends Thread{
	private Socket socket;
	private Master master;
	
	public MasterActivity(Socket socket,Master master) {
		this.socket=socket;
		this.master=master;
	}
	
	@Override
	public void run(){
		Buffer buff = new Buffer();
				while (this.isInterrupted()!=true)
				try {
					InputStream is = socket.getInputStream();
					DataInputStream dis= new DataInputStream(is);
					 String name= dis.readUTF();
					String msg=dis.readUTF();
					Message mes= new Message(name,msg);
					buff.setMsg(mes);
					master.getChat().appendText(name+"\n");
					master.getChat().appendText(msg+"\n");
					System.out.println("Я в сервере");
					this.wait();
				} catch (IOException e) {
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	}
	


