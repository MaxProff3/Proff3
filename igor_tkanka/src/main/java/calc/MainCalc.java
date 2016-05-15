package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainCalc extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("CalcFX by Tkanka =)");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
