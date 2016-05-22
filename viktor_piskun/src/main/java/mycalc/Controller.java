package mycalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	@FXML private TextField display;
	@FXML private Button eql;
	@FXML private Calc calc = new Calc();
	
	@FXML
	public void doSomething(ActionEvent event) {
		Button button = ((Button)event.getSource());
		char p = button.getText().charAt(0);		
		calc.inChar(p);
		display.setText(calc.getResult());
	}
}