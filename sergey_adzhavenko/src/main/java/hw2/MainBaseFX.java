package hw2;

import java.util.Iterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainBaseFX extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFx & Users");
		stage.setScene(createScene());
		stage.show();
	}
	Base base = new Base();
	Label title = new Label("User Base");
	TextField login = new TextField();
	TextField password = new TextField();
	Button addUser = new Button("Add New User");
	TextArea showUsers = new TextArea();
	
	public Scene createScene(){
		VBox box = new VBox(30);
		box.setAlignment(Pos.CENTER);
		
		title.setStyle("-fx-font-size:20px;-fx-text-fill:rgb(128, 0, 0)");
		login.setPromptText("Login");
		password.setPromptText("Password");
		
		login.setMaxWidth(200);
		password.setMaxWidth(200);
		
		showUsers.setMaxWidth(380);
		showUsers.setEditable(false);
		
		box.getChildren().add(title);
		box.getChildren().add(login);
		box.getChildren().add(password);
		box.getChildren().add(addUser);
		box.getChildren().add(showUsers);
		
		addUser.setOnAction(new MyEvent());
		
		Scene scene = new Scene(box,400,440);
		return scene;
	}
	class MyEvent implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			if(!login.getText().equals("") && !password.getText().equals("")){
				base.set.add(new User(login.getText(), password.getText(), null, null));
			}
			login.setText("");
			password.setText("");
			String allUsers="";
			Iterator<User> iter = base.set.iterator();
			while(iter.hasNext()){
				allUsers = allUsers + iter.next().getLogin().toString()+"\n";
			}
			showUsers.setText(allUsers);
			
		}
		
	}
}
