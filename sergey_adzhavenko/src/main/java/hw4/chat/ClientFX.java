package hw4.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientFX extends Application{

	Client client = new Client(9999);
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		client.setDaemon(true);
		client.start();
		stage.setTitle("Chat");
		stage.setScene(createScene());
		stage.show();
	}

	private VBox main;
	private HBox hbox;
	private TextField userMessage;
	private TextField userName;
	private Button sendBtn;
	private String name = "";
	
	public Scene createScene() {
		
		main=new VBox(15);
		main.setPadding(new Insets(10, 10, 10, 10));

		client.getChat().setEditable(false);
		client.getChat().setFocusTraversable(false);
		client.getChat().setPrefHeight(300);
		
		userMessage=new TextField();
		userMessage.setFocusTraversable(false);
		userMessage.setPrefHeight(50);
		userMessage.setPromptText("Enter your message..");
		
		userName=new TextField();
		userName.setPromptText("Enter your name..");
		userName.setFocusTraversable(false);
		
		hbox=new HBox(20);
		hbox.setAlignment(Pos.BASELINE_RIGHT);
		sendBtn=new Button("Send");
		sendBtn.setPrefWidth(150);
		sendBtn.setFocusTraversable(false);
		sendBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(!userMessage.getText().equals("")){
					if(!name.equals("")){
						client.send(new Message(name, userMessage.getText()));
						userMessage.setText("");
					}
					else if(!userName.getText().equals("")){
						name = userName.getText();
						client.send(new Message(name, userMessage.getText()));
						userMessage.setText("");
						userName.setEditable(false);
					}
				}
			}
		});
		hbox.getChildren().addAll(userName,sendBtn);
		main.getChildren().addAll(client.getChat(),userMessage,hbox);
		Scene scene = new Scene(main,340,430);
		return scene;
	}

	public TextField getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(TextField userMessage) {
		this.userMessage = userMessage;
	}
}

