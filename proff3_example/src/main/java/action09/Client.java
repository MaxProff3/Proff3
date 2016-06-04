package action09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Client extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Client");
		primaryStage.setScene(createScene());
		primaryStage.show();

	}

	public Scene createScene() {
		HBox box = new HBox();
		box.getChildren().add(new Button("Client"));
		return new Scene(box, 200, 100);

	}

}
