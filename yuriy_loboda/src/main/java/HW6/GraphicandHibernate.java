package HW6;

import java.util.List;

import SecondWeek.JavaFxUser.User;
import action12.Product1;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProductService;
import services.ProductServiceImpl;
import services.UserServ;
import services.UserServImpl;

public class GraphicandHibernate extends Application {
	private Tab tab2=null;
	private Tab tab3=null;
	private Tab tab4=null;
public static void main(String[] args) {
	launch(args);
}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Shop");
		stage.setScene(createScene());
		stage.show();
	}

	private Scene createScene() {
		TabPane tab= new TabPane();
		
		Tab tab1 = new Tab("Sign in");
		tab1.setContent(getTab1());
		tab.getTabs().add(tab1);
	
		
		tab2 = new Tab("Products catalog");
		tab2.setContent(HelpClass.getTab2());
		tab.getTabs().add(tab2);
		tab2.setDisable(true);
		
		tab3 = new Tab("Contructors catalog");
		tab3.setContent(HelpClass.getTab3());
		tab.getTabs().add(tab3);
		tab3.setDisable(true);
		
		tab4 = new Tab("Orders catalog");
		tab4.setContent(HelpClass.getTab4());
		tab.getTabs().add(tab4);
		tab4.setDisable(true);
		
		Scene scene = new Scene(tab,800,600);
		return scene;
	}
	
	
	private VBox getTab1(){
		VBox grid = new VBox();
		TextField login = new TextField();
		TextField psw = new TextField();
		Button send = new Button("Send");
		
		
		grid.getChildren().add(login);
		grid.getChildren().add(psw);
		grid.getChildren().add(send);
		
		send.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				UserDao uDao =new  UserDaoImpl();
				UserServ uServ = new UserServImpl(uDao);
				String login1 = login.getText();
				String psw1 = psw.getText();
				System.err.println(login1 +" "+ psw1);
				boolean result = uServ.getUser(login1, psw1);
				if (result==true){
					tab2.setDisable(false);
					tab3.setDisable(false);
					tab4.setDisable(false);
				}
				}
		});
		
		return grid;
		
	}

	
	
}
