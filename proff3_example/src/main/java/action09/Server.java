package action09;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Server extends Application {
	MyServerSocket serverThread;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		serverThread = new MyServerSocket();
		serverThread.start();
		primaryStage.setTitle("Server");
		primaryStage.setScene(createScene());
		primaryStage.show();

	}
	@Override
	public void stop() throws Exception {
		serverThread.interrupt();
	}
	public Scene createScene() {
		HBox box = new HBox();
		box.getChildren().add(new Button("Server"));		
		return new Scene(box, 200, 100);
	}
	class MyServerSocket extends Thread{
		public void run(){
			
			try {
				ServerSocket server = new ServerSocket(8086);
				while(!isInterrupted()){
					Socket socket = server.accept();		
				}
				server.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
