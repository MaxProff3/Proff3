package FourthWeek;

import java.io.IOException;
import java.net.Socket;

import SecondWeek.JavaFxUser.User;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Users extends Application   {
private Buffer buff = new Buffer();
private VBox vb;
private TextField user;
private TextArea chat;
private TextField message;
private Button btn;
private String host;
private int port;


 Users(String host,int port){
	this.host=host;
	this.port=port;
}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Users_Chat");
		stage.setScene(createScene());
		stage.show();
		
	}

	public Scene createScene() {
		 vb= new VBox();
		 user= new TextField();
		 message= new TextField();
		 btn=new Button("Send");
		 chat=new TextArea();
		
		
		vb.getChildren().add(user);
		vb.getChildren().add(chat);
		vb.getChildren().add(message);
		vb.getChildren().add(btn);
		Scene scene = new Scene(vb,300,300);
		
		
		btn.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
			
				chat.appendText(user.getText()+'\n'+message.getText()+'\n');
				Message msg = new Message(user.getText(),message.getText());
			
				try {
					buff.put(msg);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		});
		
		
		return scene;
	}
	public void getOnVChat() throws InterruptedException{
		chat.setText(buff.get().toString());
	}

}

