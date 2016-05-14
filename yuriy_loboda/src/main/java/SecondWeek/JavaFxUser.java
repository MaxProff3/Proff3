package SecondWeek;

import java.awt.ScrollPane;
import java.util.HashSet;
import java.util.Iterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxUser extends Application{
	public static void main(String[] args) {
		launch(args);
	} 

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Users list");
		stage.setScene(createScene());
		stage.show();
		
	}
	
	public Scene createScene(){
		VBox gp=new VBox();
		TextField login= new TextField();
		TextField pwd = new TextField();
		Button btn=new Button("Добавить пользователя");
		TextArea list=new TextArea();
		
		
		gp.getChildren().add(login);
		gp.getChildren().add(pwd);
		gp.getChildren().add(btn);
		gp.getChildren().add(list);
		
		
		btn.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				//String l=login.toString();
				User us=new User(login.getText(),pwd.getText());
				
				list.setText(us.toString());
				}
		});
				
				
			
		Scene scene = new Scene(gp, 400 , 600);
		return scene;
		}
	public class User{
		private String login;
		private String pwd;
		
		public User(String string, String string2) {
			this.login = string;
			this.pwd = string2;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((login == null) ? 0 : login.hashCode());
			result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			if (pwd == null) {
				if (other.pwd != null)
					return false;
			} else if (!pwd.equals(other.pwd))
				return false;
			return true;
		}

		private JavaFxUser getOuterType() {
			return JavaFxUser.this;
		}

		@Override
		public String toString() {
			return "User [login=" + login + ", pwd=" + pwd + "]";
		}

	
		
		
		
		
	}
		
	}

	
	
	
