package FourthWeek;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class User extends Application {
private	VBox gp;
private TextField name;
private TextField message;
private Button btn;
private	TextArea chat;
	private static int n=0;
	
	
	public Button getBtn() {
		return btn;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextField getMessage() {
		return message;
	}

	public void setMessage(TextField message) {
		this.message = message;
	}

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
		
		stage.setTitle("CHAT"+n);
		n+=1;
		stage.setScene(createScene());
		stage.show();
		
	}
	/*  User(TextField name,TextField message){
		  this.name=name;
		  this.message=message;
	  }
*/
	private Scene createScene()  {
		
		 gp=new VBox();
		 name= new TextField();
		 message = new TextField();
		 btn=new Button("Send");
		 chat=new TextArea();
		  
		 gp.getChildren().add(chat);
		 gp.getChildren().add(name);
		 gp.getChildren().add(message);
		 gp.getChildren().add(btn);
		 new UserActivity("localhost",3230,this).start();
		
		// new CatchMessage(this).start();
		Scene scene = new Scene(gp, 200 , 150);
		return scene;
	}
}

class UserActivity extends Thread{
	private int port;
	private String host;
	private Message msg;
	private User user;
	private Socket socket;
	private static int a=0;
	
	UserActivity(String host,int port,User user){
		this.port=port;
		this.user=user;
		this.host=host;
	}
	@Override
	public void run(){
		Buffer buff = new Buffer();
	a+=1;
	System.out.println(a);
		 user.getBtn().addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					Message msg=new Message(user.getName().getText(),user.getMessage().getText());
					new OutMessage("localhost", 3230, msg, user).start();
					try {
						buff.setMsg(msg);
						buff.setText(user.getMessage().getText());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			});
		
		
		
		try {
		
			
			msg = buff.getMsg();
			
			System.out.println(msg.toString());
		} catch (Throwable e) {	
			e.printStackTrace();
			
		
	}
	}
}


class OutMessage extends Thread {
	private User user;
	private Message msg;
	private int port;
	private String host;
	
	public OutMessage(String host,int port,Message msg,User user) {
		this.user=user;
		this.host=host;
		this.port=port;
		this.msg=msg;
	}
	@Override
	public void run(){
		
		try (Socket socket =new Socket(host,port)){
			OutputStream os=socket.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg.getUserName());
			dos.writeUTF(msg.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

