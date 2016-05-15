package hwAction04;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxUsers extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Users");
        primaryStage.setScene(createScene());
        primaryStage.show();

    }
    Button btn1;
    Button btnPrintUsers;

    TextField text1;
    TextField text2;
    
    Label labelLogin;
    Label labelPass;

    HashMap<String,String> base = new HashMap<String,String>(); 

    public Scene createScene() {
        HBox mainBox = new HBox();
                
		text1 = new TextField();
		text1.setStyle("-fx-font-size: 16pt");
		text1.setMinSize(400, 50);
        
        
        btn1 = new Button("Add");
        btn1.setStyle("-fx-font-size: 16pt");
        btn1.setMinSize(150,50);

        
        btnPrintUsers = new Button("Print users");
        btnPrintUsers.setStyle("-fx-font-size: 16pt");
        btnPrintUsers.setMinSize(150,50);

        

    
        text2 = new TextField();       
        text2.setStyle("-fx-font-size: 16pt");
        text2.setMinSize(400,50);


        btn1.setOnAction(new MyEvent());
        
        btnPrintUsers.setOnAction(new MyEvent());

        mainBox.getChildren().add(createLabel());
        mainBox.getChildren().add(createOneBox());

        Scene scene = new Scene(mainBox, 500, 205);
        return scene;
    }
    public VBox createOneBox() {
        VBox box = new VBox();
            
        box.getChildren().add(text1);
        box.getChildren().add(text2);
        box.getChildren().add(btn1);
        box.getChildren().add(btnPrintUsers);
        
        return box;
    }
    
    public VBox createLabel() {
        VBox box = new VBox();
        
        
        
        labelLogin = new Label("Login:");
        labelLogin.setStyle("-fx-font-size: 16pt");
        labelLogin.setMinSize(100,50);    
        box.getChildren().add(labelLogin);
        
        
        labelPass = new Label("Password:");
        labelPass.setStyle("-fx-font-size: 16pt");
        labelPass.setMinSize(100,50);    
        box.getChildren().add(labelPass);
            
        box.getChildren().add(text1);
        box.getChildren().add(text2);
        box.getChildren().add(btn1);
        
        return box;
    }

    class MyEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btn1) {

				String login = text1.getText();
				String pass = text2.getText();

				if (!login.equals("") && !pass.equals("")) {
					base.put(login, pass);
				}
			}

			if (event.getSource() == btnPrintUsers) {

				System.out.println("Login:   Password:");
				System.out.println();

				Set set = base.entrySet();
				Iterator i = set.iterator();
				while (i.hasNext()) {
					Map.Entry me = (Map.Entry) i.next();
					System.out.println(me.getKey() + " : " + me.getValue());
				}

			}
		}
    }
}