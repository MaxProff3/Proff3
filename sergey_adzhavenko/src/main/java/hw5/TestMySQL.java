package hw5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMySQL {
		
		// В String url указываем порт и название базы данных
		private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
		
		private static final String LOGIN = "root";
		private static final String PASSWORD = "root";
		
		/*public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
			//регестрируем драйвер
			Class.forName("com.mysql.jdbc.Driver");
			
			//подключаемся к базе данных
			Connection connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			
			//создание статических запросов(без переменных)
			Statement statment = connection.createStatement();
			
			//вставить данные в таблицу
			//statment.execute("INSERT INTO animal(animal_name,animal_desk) values ('name','desc');");
			
			//запросы типа insert, update, delete (получать данные этим запросом нельзя)
			//возвращает 1, если запрос выполнился и 0 если нет
			int res = statment.executeUpdate("update animal set animal_name='Новое имя' where id=3;");
			System.out.println(res);
			
			//можно выполнять только select
			ResultSet rs = statment.executeQuery("select * from animal");

			//поместить все запросы в один пакет, 
			//и выполнить при помощи statment.executeBatch();
			statment.addBatch("INSERT INTO animal(animal_name,animal_desk) values ('name1','desc1');");
			statment.addBatch("INSERT INTO animal(animal_name,animal_desk) values ('name2','desc2');");
			statment.addBatch("INSERT INTO animal(animal_name,animal_desk) values ('name3','desc3');");
			
			statment.executeBatch();
			
			//очищает предыдущие запросы добавленные в statment.addBatch
			statment.clearBatch();
			
			statment.close();
			//закрываем подключение к базе данных
			connection.close();

		}*/
}
