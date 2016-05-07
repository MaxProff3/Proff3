package calc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class View implements Initializable {

	private MyCalc processor;
	@FXML
	private Label result;

	@FXML
	private void handleButtonAction(ActionEvent event) {

		Button b = (Button) event.getSource();
		processor.inChar(b.getText().charAt(0));
		result.setText(processor.getResult());

	}

	@FXML
	private void handleKeyEventPressed(KeyEvent event) {
		if (event.getCode().toString().equals("ESCAPE"))
			sendCommand("C");
		if (event.getCode().toString().equals("ENTER"))
			sendCommand("=");
	}

	@FXML
	private void handleKeyEvent(KeyEvent even) {

		String typedChar = even.getCharacter();
		if (typedChar.length() > 0)
			sendCommand(even.getCharacter());

	}

	private void sendCommand(String command) {
		processor.inChar(command.charAt(0));
		result.setText(processor.getResult());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		processor = new MyCalc();
	}

}
