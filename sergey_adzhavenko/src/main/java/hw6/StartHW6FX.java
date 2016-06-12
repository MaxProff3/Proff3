package hw6;

import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.HibernateUtil;

public class StartHW6FX extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("HW6");
		stage.setScene(createScene());
		stage.show();
	}

	private Tab tabStep1;
	private Tab tabStep2;
	private Tab tabStep3;
	private Tab tabStep4;
	private Tab tabStep5;
	
	private Scene createScene() {
		TabPane tabPane = new TabPane();
		
		tabStep1 = new Tab("Step 1 >>");
		tabStep1.setContent(getStep1Box());
		tabPane.getTabs().add(tabStep1);

		tabStep2 = new Tab("Step 2 >>");
		tabStep2.setContent(getStep2Box());
		//tabStep2.setDisable(true);
		tabPane.getTabs().add(tabStep2);

		tabStep3 = new Tab("Step 3 >>");
		tabStep3.setContent(new GridPane());
		tabPane.getTabs().add(tabStep3);

		tabStep4 = new Tab("Step 4 >>");
		tabStep4.setContent(new GridPane());
		tabPane.getTabs().add(tabStep4);

		tabStep5 = new Tab("Step 5");
		tabStep5.setContent(new GridPane());
		tabPane.getTabs().add(tabStep5);
		
		return new Scene(tabPane,700,500);
	}
	
	private VBox vboxStep1;
	private Label titleLbl;
	private TextField login;
	private TextField password;
	private Button logInBtn;
	
	private VBox getStep1Box(){
		vboxStep1 = new VBox(30);
		vboxStep1.setAlignment(Pos.CENTER);
		
		titleLbl = new Label("PROFF3");
		titleLbl.setStyle("-fx-font-size:20px;-fx-text-fill:rgb(128, 0, 0)");
		
		login = new TextField();
		login.setPromptText("Login");
		login.setMaxWidth(200);
		
		password = new TextField();
		password.setPromptText("Password");
		password.setMaxWidth(200);
		
		logInBtn = new Button("Log In");
		logInBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		       if(!login.getText().equals("") && !password.getText().equals("")){
		    	   	Locale.setDefault(Locale.ENGLISH);
		    	   	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		   			Session session = null;
		   			try{
		   				session = sessionFactory.openSession();
		   				///////////////
		   				
		   			}catch (HibernateException e1) {
		   				System.out.println("Error!!!");
		   				e1.printStackTrace();
		   			}finally {
		   				if (session != null) {
		   					session.close();
		   				}
		   				if (sessionFactory != null) {
		   					sessionFactory.close();
		   				}
		   				System.out.println("Session is closed!");
		   			}
		       }
		    }
		});
		vboxStep1.getChildren().addAll(titleLbl, login, password, logInBtn);
		
		return vboxStep1;
	}
	
	private VBox vboxStep2;
	private ObservableList<Product> obsList;
	private TableView productTable;
	private TableColumn productNameColumn;
	private TableColumn productCodeColumn;
	
	private VBox getStep2Box(){
		vboxStep2 = new VBox(20);
		
		obsList = FXCollections.observableArrayList();
		
		productTable = new TableView(obsList);
		productTable.setEditable(true);
		
		productCodeColumn = new TableColumn<>("Code");
		productNameColumn = new TableColumn<>("Name");
		
		productTable.getColumns().addAll(productCodeColumn, productNameColumn);
		
		vboxStep2.getChildren().addAll(productTable);
		
		return vboxStep2;
	}
}
