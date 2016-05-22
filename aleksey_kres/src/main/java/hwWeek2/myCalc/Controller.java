package hwWeek2.myCalc;



import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application {

 @Override
 public void start(Stage primaryStage) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("MCalc.fxml"));

  Scene scene = new Scene(root, 240, 330);

  primaryStage.setResizable(false);
  primaryStage.setTitle("Welcome");
  primaryStage.setScene(scene);
  primaryStage.show();
 }

 public static void main(String[] args) {
  launch(args);
 }



public class MyCalc extends AbstractCalc {

 @Override
 public void inChar(char p) {

  int current = getIntRes();

  if (!Character.isDigit(p)) {
   if (p == '=') {
    if (operation == '/') {
     result = (current == 0) ? ByZero : String.valueOf(methodCalc(temp, current, operation));
    } else if (p == '+' || p == '-' || p == '*') {
     if(operation == p) {      
      result = String.valueOf(methodCalc(temp, current, operation));
     } else{
      result = String.valueOf(methodCalc(temp, current, operation));
     }
    }
    operation = ' ';
    temp = 0;
   } else {
    operation = p;
    temp = Integer.valueOf(result);
   }
  } else {
   if (getIntRes() != 0 && current == temp) {
    result = "";
   }
   if (current == 0) {
    result = "" + p;
   } else {
    result += p;
   }
  }
 }

 private int getIntRes() {
	// TODO Auto-generated method stub
	return 0;
}

private int methodCalc(int a1, int a2, char op) {
  switch (op) {
  case '+':
   return a1 + a2;
  case '-':
   return a1 - a2;
  case '*':
   return a1 * a2;
  case '/':
   return a1 / a2;
  default:
   return 0;
  }
 }

}}