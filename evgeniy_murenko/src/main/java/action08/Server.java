package action08;

import java.awt.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Server extends Application {
	private Button btn;
	private TextField textField;
	private TextArea textArea;

	public static void main(String[] args) {
		launch(args); // - start
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MyChat_Server");
		primaryStage.setScene(createScene());
		primaryStage.show();
	}

	public Scene createScene() {
		Pane pane = new Pane();
		
		btn = new Button("Send");
		btn.setTranslateX(10);
		btn.setTranslateY(180);
		btn.setPrefSize(30, 30);
		pane.getChildren().addAll(btn);
		return null;
	}

	class MyEvent implements EventHandler<ActionEvent> {

		public void check(char ch) {
		}

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == null) {
			}
		}
	}
}
