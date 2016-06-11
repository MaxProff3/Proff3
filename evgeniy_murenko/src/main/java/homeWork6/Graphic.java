package homeWork6;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.HibernateUtil;

public class Graphic extends Application {

	private boolean isVisible = true;
	private TextField textUserName;
	private PasswordField textUserPass;
	private Button btnAdd;
	private Button btnEdit;
	private Button btnRemove;
	private Button btnLogin;
	
	private Tab tab2;
	private Tab tab3;
	private Tab tab4;
	private Tab tab5;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Application");
		stage.setScene(createScene());
		stage.show();
	}

	public Scene createScene() {
		TabPane tabPane = new TabPane();
		

		Tab tab1 = new Tab("Login");
		tab1.setContent(getTab1());
		tabPane.getTabs().add(tab1);

		tab2 = new Tab("Catalogs Employees");
		tab2.setContent(getTab2());
		tab2.setDisable(isVisible);
		tabPane.getTabs().add(tab2);

		tab3 = new Tab("Catalogs Users");
		tab3.setContent(getTab2());
		tab3.setDisable(isVisible);
		tabPane.getTabs().add(tab3);

		tab4 = new Tab("Catalogs Contructors");
		tab4.setContent(getTab2());
		tab4.setDisable(isVisible);
		tabPane.getTabs().add(tab4);

		tab5 = new Tab("List of Orders");
		tab5.setContent(getTab2());
		tab5.setDisable(isVisible);
		tabPane.getTabs().add(tab5);

		return new Scene(tabPane, 800, 600);

	}

	public GridPane getTab1() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		textUserName = new TextField();
		grid.add(new Label("Login:"), 0, 0);
		grid.add(textUserName, 1, 0);

		textUserPass = new PasswordField();
		grid.add(new Label("Password:"), 0, 1);
		grid.add(textUserPass, 1, 1);

		btnLogin = new Button("Login");
		btnLogin.setTranslateX(60);
		btnLogin.setTranslateY(-10);
		btnLogin.setPrefSize(90, 30);
		grid.add(btnLogin, 1, 3);
		btnLogin.setOnAction(new MyEvent());
		return grid;

	}

	public Group getTab2() {
		Group group = new Group();
		group.getChildren().add(new Button("Тут могла быть ваша реклама!"));
		return group;
	}

	public void stop() {
		HibernateUtil.getSessionFactory().close();
	}

	class MyEvent implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btnAdd) {
				System.out.println("Add");
			} else if (event.getSource() == btnEdit) {
				System.out.println("Edit");
			} else if (event.getSource() == btnRemove) {
				System.out.println("Remove");
			} else if(event.getSource() == btnLogin){
				System.out.println("login");
				
				isVisible = false;
				
			}
		}
	}
}
