package FourthWeek;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MasterFx extends Application {
	private TextArea chat;
	private ServerSocket server;
	private int port;
	private Buffer buff = new Buffer();
	
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Master_chat");
		stage.setScene(createScene());
		stage.show();
		
	}

	private Scene createScene() {
		VBox vb= new VBox();
		TextArea chat=new TextArea();
		vb.getChildren().add(chat);
		Scene scene = new Scene(vb,300,300);
		
		return scene;
	}
	public void getOnVChat() throws InterruptedException{
		chat.setText(buff.get().toString());
	}

}

class Master implements Runnable{
	private MasterFx mFx=new MasterFx();
	private Stage st = new Stage();
	private ServerSocket server;
	private int port;
	Master(int port){
		this.port=port;
	}
	@Override
	public void run() {
		//	Socket socket = server.accept();
		try {
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}	



