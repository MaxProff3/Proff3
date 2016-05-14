package mycalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	@FXML private TextField display;
	@FXML private Button eql;
	@FXML private Calc calc = new Calc();
//	public Button button;
	
	@FXML
	public void doSomething(ActionEvent event) {
		char p = ((Button)event.getSource()).getText().charAt(0);		
		calc.inChar(p);
		display.setText(calc.getResult());
	}
}

//	private void processNum(ActionEvent event) {
//		char digit = ((Button)event.getSource()).getText().charAt(0);
//		String oldTxt = display.getText();
//		String newTxt = oldTxt + digit;
//		if(oldTxt.equals("0")) {
//			newTxt = "" + digit;
//		}
//		calc.inChar(digit);
//		display.setText(newTxt);
//	}

//	private void processOp(ActionEvent event) {
//		char x = ((Button)event.getSource()).getText().charAt(0);
//		calc.inChar(x);
//		System.out.println(x);
//	}

//	private void processEql(ActionEvent event) {
//		char x = ((Button)event.getSource()).getText().charAt(0);
//		calc.inChar(x);
//		System.out.println(x);
//	}