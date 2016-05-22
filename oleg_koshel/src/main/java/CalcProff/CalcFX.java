package CalcProff;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalcFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First application");
        primaryStage.setScene(createScene());
        primaryStage.show();

    }

    AbstractCalc testCalc = new AbstractCalc();

    TextField text;

    Button btnCE,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn_div,btn_mult,btn_minus,btn_plus,btn_equals;


    public Scene createScene() {

        VBox mainBox = new VBox();

        HBox boxText = new HBox();
        HBox boxCE = new HBox();
        HBox box789 = new HBox();
        HBox box456 = new HBox();
        HBox box123 = new HBox();


        mainBox.getChildren().add(boxText);
        mainBox.getChildren().add(boxCE);
        mainBox.getChildren().add(box789);
        mainBox.getChildren().add(box456);
        mainBox.getChildren().add(box123);


        text = new TextField();
        text.setStyle("-fx-font-size: 16pt");
        text.setMinSize(400,50);
        boxText.getChildren().add(text);


        btnCE =createAndSetSeizeButton(btnCE,"CE");
        btnCE.setStyle("-fx-text-fill: red;-fx-font-size: 16pt");
        //btnCE.setOnAction(new MyEvent());

        btn0 =createAndSetSeizeButton(btn0,"0");
        btn_equals =createAndSetSeizeButton(btn_equals,"=");
        btn_div =createAndSetSeizeButton(btn_div,"/");

        boxCE.getChildren().add(btnCE);
        boxCE.getChildren().add(btn0);
        boxCE.getChildren().add(btn_equals);
        boxCE.getChildren().add(btn_div);



        btn7 =createAndSetSeizeButton(btn7,"7");
        btn8 =createAndSetSeizeButton(btn8,"8");
        btn9 =createAndSetSeizeButton(btn8,"9");
        btn_mult =createAndSetSeizeButton(btn_mult,"*");



        box789.getChildren().add(btn7);
        box789.getChildren().add(btn8);
        box789.getChildren().add(btn9);
        box789.getChildren().add(btn_mult);


        btn4 =createAndSetSeizeButton(btn4,"4");
        btn5 =createAndSetSeizeButton(btn5,"5");
        btn6 =createAndSetSeizeButton(btn6,"6");
        btn_minus =createAndSetSeizeButton(btn_minus,"-");

        box456.getChildren().add(btn4);
        box456.getChildren().add(btn5);
        box456.getChildren().add(btn6);
        box456.getChildren().add(btn_minus);


        btn1 =createAndSetSeizeButton(btn1,"1");
        btn2 =createAndSetSeizeButton(btn2,"2");
        btn3 =createAndSetSeizeButton(btn3,"3");
        btn_plus =createAndSetSeizeButton(btn_plus,"+");

        box123.getChildren().add(btn1);
        box123.getChildren().add(btn2);
        box123.getChildren().add(btn3);
        box123.getChildren().add(btn_plus);



        Scene scene = new Scene(mainBox, 400, 350);
        return scene;
    }

    public Button createAndSetSeizeButton(Button b,String symbol){

        b = new Button(symbol);
        b.setMinSize(100,75);
        b.setStyle("-fx-font-size: 16pt");

        b.setOnAction(new MyEvent());

        return b;

    }

    class MyEvent implements EventHandler<ActionEvent> {
        private String name;

        @Override
        public void handle(ActionEvent event) {


            if (event.getSource() == btn0){

                testCalc.inChar('0');
            }
            else if (event.getSource() == btn1){testCalc.inChar('1');}
            else if (event.getSource() == btn2){testCalc.inChar('2');}
            else if (event.getSource() == btn3){testCalc.inChar('3');}
            else if (event.getSource() == btn4){testCalc.inChar('4');}
            else if (event.getSource() == btn5){testCalc.inChar('5');}
            else if (event.getSource() == btn6){testCalc.inChar('6');}
            else if (event.getSource() == btn7){testCalc.inChar('7');}
            else if (event.getSource() == btn8){testCalc.inChar('8');}
            else if (event.getSource() == btn9){testCalc.inChar('9');}
            else if (event.getSource() == btn0){testCalc.inChar('0');}

            else if (event.getSource() == btn_plus){testCalc.inChar('+');}
            else if (event.getSource() == btn_minus){testCalc.inChar('-');}
            else if (event.getSource() == btn_mult){testCalc.inChar('*');}
            else if (event.getSource() == btn_div){testCalc.inChar('/');}
            else if (event.getSource() == btn_equals){testCalc.inChar('=');}
            else if (event.getSource() == btnCE){testCalc.inChar('C');}


            text.setText(testCalc.getResult());

        }
    }
}
