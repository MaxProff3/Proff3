package action09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Server extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Server");
		primaryStage.setScene(createScene());
		primaryStage.show();
		
	}
	
	public Scene createScene(){
		HBox box = new HBox();
		box.getChildren().add(new Button("Server"));
		return new Scene(box, 200, 100);
	}

}
