package hw1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainCalc extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		stage.setScene(createScene());
		stage.setResizable(false);
		stage.show();
	}
	MyCalc calc = new MyCalc();
	VBox box = new VBox(2);
	HBox first = new HBox();
	HBox second = new HBox(2);
	HBox third = new HBox(2);
	HBox fourth = new HBox(2);
	HBox fifth = new HBox(2);
	
	Button one = new Button("1");
	Button two = new Button("2");
	Button three = new Button("3");
	Button four = new Button("4");
	Button five = new Button("5");
	Button six = new Button("6");
	Button seven = new Button("7");
	Button eight = new Button("8");
	Button nine = new Button("9");
	Button zero = new Button("0");
	
	Button plus = new Button("+");
	Button minus = new Button("-");
	Button multiply = new Button("*");
	Button divide = new Button("/");
	Button equal = new Button("=");
	
	TextField display = new TextField();
	
	public Scene createScene(){
		first.setAlignment(Pos.CENTER);
		first.setPadding(new Insets(7, 0, 3, 0));
		second.setAlignment(Pos.CENTER);
		third.setAlignment(Pos.CENTER);
		fourth.setAlignment(Pos.CENTER);
		fifth.setAlignment(Pos.CENTER);
		
		display.setFont(new Font(22));
		display.setText(calc.getResult());
		display.setAlignment(Pos.CENTER_RIGHT);
		display.setEditable(false);
		display.setMaxWidth(246);
		display.setPrefHeight(55);

		one.setFont(Font.font (20));
		two.setFont(Font.font (20));
		three.setFont(Font.font (20));
		four.setFont(Font.font (20));
		five.setFont(Font.font (20));
		six.setFont(Font.font (20));
		seven.setFont(Font.font (20));
		eight.setFont(Font.font (20));
		nine.setFont(Font.font (20));
		zero.setFont(Font.font (20));
		plus.setFont(Font.font (20));
		minus.setFont(Font.font (20));
		multiply.setFont(Font.font (20));
		divide.setFont(Font.font (20));
		equal.setFont(Font.font (20));
		
		one.setPrefSize(60, 50);
		two.setPrefSize(60, 50);
		three.setPrefSize(60, 50);
		four.setPrefSize(60, 50);
		five.setPrefSize(60, 50);
		six.setPrefSize(60, 50);
		seven.setPrefSize(60, 50);
		eight.setPrefSize(60, 50);
		nine.setPrefSize(60, 50);
		zero.setPrefSize(60, 50);
		plus.setPrefSize(60, 50);
		minus.setPrefSize(60, 50);
		multiply.setPrefSize(60, 50);
		divide.setPrefSize(60, 50);
		equal.setPrefSize(122, 50);
		
		box.getChildren().addAll(first,second,third,fourth,fifth);
		
		first.getChildren().add(display);
		second.getChildren().addAll(seven,eight,nine,multiply);
		third.getChildren().addAll(four,five,six,divide);
		fourth.getChildren().addAll(one,two,three,minus);
		fifth.getChildren().addAll(zero,equal,plus);

		
		one.setOnAction(new MyEvent());
		two.setOnAction(new MyEvent());
		three.setOnAction(new MyEvent());
		four.setOnAction(new MyEvent());
		five.setOnAction(new MyEvent());
		six.setOnAction(new MyEvent());
		seven.setOnAction(new MyEvent());
		eight.setOnAction(new MyEvent());
		nine.setOnAction(new MyEvent());
		zero.setOnAction(new MyEvent());
		plus.setOnAction(new MyEvent());
		minus.setOnAction(new MyEvent());
		multiply.setOnAction(new MyEvent());
		divide.setOnAction(new MyEvent());
		equal.setOnAction(new MyEvent());
		
		Scene scene = new Scene(box,250,270);
		return scene;
	}

	class MyEvent implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			calc.inChar(((Button)event.getSource()).getText().toString().charAt(0));
			display.setText(calc.getResult());
		}
		
	}
}
