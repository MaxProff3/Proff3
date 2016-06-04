package homeWork5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class JDBCexample extends Application {

	private TextField textUserName;
	private PasswordField textUserPass;
	private Button btnAdd;
	private Button btnEdit;
	private Button btnRemove;
	private Button btnExit;
	private ListView<String> list;
	private ObservableList<String> items;

	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/proff3";
	private static String login;
	private static String pass;

	private static List<String> listUsers;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		inputDate();
		login = textUserName.getText();
		pass = textUserPass.getText();
		connect();
		primaryStage.setTitle("MyChat_Client");
		primaryStage.setScene(createScene());
		primaryStage.show();
	}

	private Scene createScene() {
		Pane pane = new Pane();

		list = new ListView<String>();
		items = FXCollections.observableArrayList(listUsers);
		list.setItems(items);
		list.setTranslateX(10);
		list.setTranslateY(10);
		list.setPrefSize(330, 280);
		pane.getChildren().addAll(list);

		btnAdd = new Button("Add");
		btnAdd.setTranslateX(350);
		btnAdd.setTranslateY(10);
		btnAdd.setPrefSize(90, 30);
		pane.getChildren().addAll(btnAdd);

		btnEdit = new Button("Edit");
		btnEdit.setTranslateX(350);
		btnEdit.setTranslateY(50);
		btnEdit.setPrefSize(90, 30);
		pane.getChildren().addAll(btnEdit);

		btnRemove = new Button("Remove");
		btnRemove.setTranslateX(350);
		btnRemove.setTranslateY(90);
		btnRemove.setPrefSize(90, 30);
		pane.getChildren().addAll(btnRemove);

		btnExit = new Button("Exit");
		btnExit.setTranslateX(350);
		btnExit.setTranslateY(260);
		btnExit.setPrefSize(90, 30);
		pane.getChildren().addAll(btnExit);

		btnAdd.setOnAction(new MyEvent());
		btnEdit.setOnAction(new MyEvent());
		btnRemove.setOnAction(new MyEvent());
		btnExit.setOnAction(new MyEvent());

		Scene scene = new Scene(pane, 450, 300);
		return scene;
	}

	class MyEvent implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btnAdd) {
				addUser();
			} else if (event.getSource() == btnEdit) {
				if (list.getSelectionModel().getSelectedItem() != null) {
					String userNameEdit = list.getSelectionModel().getSelectedItem();
					String query = "select * from users where name = '" + userNameEdit + "';";
					List<String> aboutUserList = informationAboutUser(query);
					userEdit(aboutUserList);
				}
			} else if (event.getSource() == btnRemove) {
				if (list.getSelectionModel().getSelectedItem() != null) {
					String userNameRemove = list.getSelectionModel().getSelectedItem();
					String query = "DELETE FROM users WHERE name='" + userNameRemove + "'";
					actionOnUser(query);
				}
			} else if (event.getSource() == btnExit) {
				System.out.println("Exit");
			}
		}
	}
	
	private List<String> informationAboutUser(String query) {
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connect = null;
		List<String> list = new ArrayList<>();
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}

	private void userEdit(List<String> aboutUserList) {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Редактирывание пользывателя");
		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField userName = new TextField();
		userName.setText(aboutUserList.get(1));
		grid.add(new Label("Username:"), 0, 0);
		grid.add(userName, 1, 0);

		TextField userLogin = new TextField();
		userLogin.setText(aboutUserList.get(2));
		grid.add(new Label("Login:"), 0, 1);
		grid.add(userLogin, 1, 1);

		TextField userPass = new TextField();
		userPass.setText(aboutUserList.get(3));
		grid.add(new Label("Password:"), 0, 2);
		grid.add(userPass, 1, 2);

		TextField userEmployeer = new TextField();
		userEmployeer.setText(aboutUserList.get(4));
		grid.add(new Label("Employeer:"), 0, 3);
		grid.add(userEmployeer, 1, 3);

		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		userLogin.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.getDialogPane().setContent(grid);
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(userLogin.getText(), userName.getText());
			}
			return null;
		});
		Optional<Pair<String, String>> result = dialog.showAndWait();
		result.ifPresent(usernamePassword -> {
			String query = "update users set name= '" + userName.getText() + "', login = '" + userLogin.getText()
					+ "', pass = '" + userPass.getText() + "', employee_id = '" + userEmployeer.getText()
					+ "' where id=" + aboutUserList.get(0) + ";";
			actionOnUser(query);
		});

	}

	private void addUser() {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Добавление пользывателя");
		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField userName = new TextField();
		userName.setPromptText("User name");
		grid.add(new Label("Username:"), 0, 0);
		grid.add(userName, 1, 0);

		TextField userLogin = new TextField();
		userLogin.setPromptText("Login");
		grid.add(new Label("Login:"), 0, 1);
		grid.add(userLogin, 1, 1);

		TextField userPass = new TextField();
		userPass.setPromptText("Password");
		grid.add(new Label("Password:"), 0, 2);
		grid.add(userPass, 1, 2);

		TextField userEmployeer = new TextField();
		userEmployeer.setPromptText("0 - 4");
		grid.add(new Label("Employeer:"), 0, 3);
		grid.add(userEmployeer, 1, 3);

		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		userLogin.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.getDialogPane().setContent(grid);
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(userLogin.getText(), userName.getText());
			}
			return null;
		});
		Optional<Pair<String, String>> result = dialog.showAndWait();
		result.ifPresent(usernamePassword -> {
			String query = "INSERT INTO `users` (`name`, `login`, `pass`, `employee_id`) " + "VALUES ('"
					+ userName.getText() + "', '" + userLogin.getText() + "', '" + userPass.getText() + "', "
					+ userEmployeer.getText() + ")";
			actionOnUser(query);
		});

	}

	private void actionOnUser(String query) {
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		items.clear();
		connect();
		items = FXCollections.observableArrayList(listUsers);
		list.setItems(items);
	}

	private static void connect() {
		listUsers = new ArrayList<>();
		String query = "select name from users";
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				listUsers.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public void inputDate() {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Подключение к MySQL");
		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		textUserName = new TextField();
		textUserName.setPromptText("Username");
		textUserPass = new PasswordField();
		textUserPass.setPromptText("Password");
		grid.add(new Label("Username:"), 0, 0);
		grid.add(textUserName, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(textUserPass, 1, 1);
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		textUserName.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.getDialogPane().setContent(grid);
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(textUserName.getText(), textUserPass.getText());
			}
			return null;
		});
		Optional<Pair<String, String>> result = dialog.showAndWait();
		result.ifPresent(usernamePassword -> {
			// System.out.println("Username=" + usernamePassword.getKey() + ",
			// IP adress" + usernamePassword.getValue());
		});
	}
}
