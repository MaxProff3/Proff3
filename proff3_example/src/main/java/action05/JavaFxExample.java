package action05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFxExample extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MyApp");
		primaryStage.setScene(newScene());
		primaryStage.show();

	}

	public Scene newScene() {
		HBox box = new HBox();
		
		
	}

}
