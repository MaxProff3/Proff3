package action08Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ServerChat extends Application {
	private TextArea textArea;
	private List <ServerForClients> list = new ArrayList<>();

	public static void main(String[] args) {
		launch(args); // - start
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MyChat_Server");
		primaryStage.setScene(createScene());
		primaryStage.show();
		int port = 33334; // <================== PORT
		new Server(port).start();
	}

	public Scene createScene() {
		Pane pane = new Pane();
		textArea = new TextArea();
		textArea.setTranslateX(10);
		textArea.setTranslateY(10);
		textArea.setPrefSize(280, 350);
		pane.getChildren().addAll(textArea);

		Scene scene = new Scene(pane, 300, 400);
		return scene;
	}

	class Server extends Thread {
		private ServerSocket server;
		private final int port;
		public Server(int p) {
			port = p;
		}
		public void run() {
			try {
				server = new ServerSocket(port);
				while (true) {
					Socket socket = server.accept();
					ServerForClients sfc = new ServerForClients(socket);
					list.add(sfc);
					sfc.start();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}

	class ServerForClients extends Thread {
		private Socket socket;

		public ServerForClients(Socket s) {
			socket = s;
		}
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				OutputStream os ;
				DataOutputStream dos ;
				String tempLine = "";
				while (true) {
					tempLine = dis.readUTF();
					textArea.setText(textArea.getText()+tempLine+"\n"); // принял и записал в текстарену
					for (int i =0; i < list.size(); i++){
						os = list.get(i).socket.getOutputStream();
						dos = new DataOutputStream(os);
						dos.writeUTF(textArea.getText());
						dos.flush();
					}
					//dos.writeUTF(textArea.getText()); // тправка обратно
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public void outMessage(String string){
			System.out.println("outmsg start");
			for (int i = 0; i < list.size(); i++){	
				try {
					System.out.println(i);
					OutputStream os = list.get(i).socket.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);
					dos.writeUTF(textArea.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
}
