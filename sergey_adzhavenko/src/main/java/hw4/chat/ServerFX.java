package hw4.chat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServerFX extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Server server = new Server(9999);
		server.setDaemon(true);
		server.start();
		stage.setTitle("Server");
		stage.setScene(createScene());
		stage.show();
	}
	
	private VBox mainBox;
	
	
	public Scene createScene() {
		mainBox=new VBox();
		mainBox.setPadding(new Insets(10, 10, 10, 10));
		
		
		Server.getChatWindow().setEditable(false);
		Server.getChatWindow().setFocusTraversable(false);
		Server.getChatWindow().setPrefHeight(400);
		
		mainBox.getChildren().add(Server.getChatWindow());
		Scene scene = new Scene(mainBox,350,420);
		return scene;
	}
}

