package action08Chat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;


public class ClientChat extends Application {
	private Button btnSend;
	private TextArea textArea; // all message
	private TextField textField; // user message
	private TextField textUserName;
	private TextField textIpServer;
	private String userName;
	private String serverIp;
	private Message msg;
	private int port = 33335; //<===================PORT 
	private Socket socket;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		inputDate();
		socket = new Socket("127.0.0.1", port);
		primaryStage.setTitle("MyChat_Client");
		userName = textUserName.getText();
		serverIp = textIpServer.getText();
		primaryStage.setScene(createScene());
		primaryStage.show();
	}

	public void inputDate() {
		//Dialog<Pair<String, String>> dialog = new Dialog<>();
		//dialog.setTitle("My Chat -> Подготовка к подключению");
		// dialog.setHeaderText("Look, a Custom Login Dialog");

		//ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		//dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		textUserName = new TextField();
		textUserName.setPromptText("Username");

		textIpServer = new TextField();
		textIpServer.setPromptText("IP adress");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(textUserName, 1, 0);
		grid.add(new Label("IP adress:"), 0, 1);
		grid.add(textIpServer, 1, 1);
//		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
//		loginButton.setDisable(true);
//		textUserName.textProperty().addListener((observable, oldValue, newValue) -> {
//			loginButton.setDisable(newValue.trim().isEmpty());
//		});
//		dialog.getDialogPane().setContent(grid);
//		dialog.setResultConverter(dialogButton -> {
//			if (dialogButton == loginButtonType) {
//				return new Pair<>(textUserName.getText(), textIpServer.getText());
//			}
//			return null;
//		});
//		Optional<Pair<String, String>> result = dialog.showAndWait();
//		result.ifPresent(usernamePassword -> {
//			System.out.println("Username=" + usernamePassword.getKey() + ", IP adress" + usernamePassword.getValue());
//		});
	}

	public Scene createScene() {

		Pane pane = new Pane();

		textArea = new TextArea();
		textArea.setTranslateX(10);
		textArea.setTranslateY(10);
		textArea.setPrefSize(330, 200);
		pane.getChildren().addAll(textArea);

		textField = new TextField();
		textField.setTranslateX(10);
		textField.setTranslateY(230);
		textField.setPrefSize(270, 50);
		pane.getChildren().addAll(textField);

		btnSend = new Button("Send");
		btnSend.setTranslateX(290);
		btnSend.setTranslateY(230);
		btnSend.setPrefSize(50, 50);
		pane.getChildren().addAll(btnSend);

		btnSend.setOnAction(new MyEvent());

		Scene scene = new Scene(pane, 350, 300);
		return scene;
	}

	class MyEvent implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btnSend) {
				if (!textField.getText().equals(null)) {
					msg = new Message(textField.getText(), textUserName.getText());
					textArea.setText(textArea.getText() + msg.toString() + "\n");
					textField.setText("");
					try {
						InputStream is = socket.getInputStream();
						OutputStream os = socket.getOutputStream();

						DataInputStream dis = new DataInputStream(is);
						DataOutputStream dos = new DataOutputStream(os);
						
						dos.writeUTF(msg.toString());
						dos.flush(); // заставляем поток закончить передачу
						textArea.setText(dis.readUTF());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
