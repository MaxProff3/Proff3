package hw5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
13* попробовать сделать с помощью одного запроса(13 с помощью подзапроса) 
*/

public class MainMySQL {
	
	private static final String DRIVER_NAME ="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/proff3";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		Connection connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
		Statement statement = connection.createStatement();
		
		/*Задача1. Добавить в таблицу пользователя Гришу с ролью manager.
		statement.execute("insert into users (name,login,pass) values ('Гриша','greg','1111');");
		*/
		
		/*Задача2. Получить список пользователей, которые не привязаны к работникам.
		ResultSet rs = statement.executeQuery("select * from users where employee_id=0;");
		while(rs.next()){
			System.out.println("id="+rs.getInt(1) + ", " + rs.getString(2)
			+ ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getInt(5));
		}
		*/
		
		/*Задача3. Получить список пользователей, которые привязаны к работникам.
		ResultSet rs = statement.executeQuery("select * from users where employee_id!=0;");
		while(rs.next()){
			System.out.println("id="+rs.getInt(1) + ", " + rs.getString(2)
			+ ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getInt(5));
		}
		*/
		
		/*Задача4. Получить список работников, оклад которых в пределах от 100 до 250.(between)
		ResultSet rs = statement.executeQuery("select * from employees where salary in (100, 250);");
		while(rs.next()){
			System.out.println("id="+rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
		}
		*/
		
		/*Задача5. Получить список пользователей в имена которых входит слово user.(like)
		ResultSet rs = statement.executeQuery("select * from users where name like 'user%';");
		while(rs.next()){
			System.out.println("id="+rs.getInt(1) + ", " + rs.getString(2)
			+ ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getInt(5));
		}
		*/
		
		/*Задача6. Получить логины пользователей, у которых наименования заканчиваются на "vich".(like)
		ResultSet rs = statement.executeQuery("select login from users where name like '%vich';");
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		*/
		
		/*Задача7. Получить уникальный список паролей пользователей.(distinct)
		ResultSet rs = statement.executeQuery("select distinct pass from users;");
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		*/
		
		/*Задача8. Получить список пользователей
		 * (колонки:логин,имя пользователя и имя работника), 
		 * которые привязаны к работникам.
		ResultSet rs = statement.executeQuery("select users.login, users.name, employees.name "
				+ "from users join employees on users.employee_id = employees.id;");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
		}
		*/
		
		/*Задача9. Получить список заказов с колонками:имя работника, 
		 * имя пользователя, номер заказа, имя заказчика.
		ResultSet rs = statement.executeQuery("select employees.name, users.name, orders.number, contructors.name from orders "
				+ "join contructors on orders.contructor_id = contructors.id "
				+ "join users on users.id = orders.user_id join employees on employees.id = users.employee_id;");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4));
		}
		*/
		
		/* С ДУБЛИКАТАМИ!!!
		 * Задача10. Получить для всех пользователей соответсвие роли
		и признак присвоения этой роли этому пользователю.
		Поля: имя пользователя, имя роли, есть/нет.
		ResultSet rs = statement.executeQuery("select distinct users.name, "
				+ "if(users.id = roles_users.user_id and roles.id = roles_users.role_id,roles.name,'null') as role,"
				+ "if(users.id = roles_users.user_id and roles.id = roles_users.role_id,'YES','NO') as has_role "
				+ "from users, roles, roles_users");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
		}*/
		
		
		/*Задача 11. Отобразить список пользователей без роли.
		ResultSet rs = statement.executeQuery("select * from proff3.users where id not in "
				+ "(select user_id from roles_users);");
		while(rs.next()){
			System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3)
			+ ", " + rs.getString(4) + ", " + rs.getInt(5));
		}*/
		
		/*Задача 12. Отобразить максимальный заказ каждого пользователя(имя  и максимальная сумма)
		ResultSet rs = statement.executeQuery("select users.name, max(orders.summa) as max_summa "
				+ "from users, orders "
				+ "where users.id=orders.user_id "
				+ "group by users.name");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getString(2));
		}*/
		
		/*Задача 13. Отобразить пользователей, у которых минимальная сумма заказа 
		больше чем среднее по всем заказам.
		ResultSet rs = statement.executeQuery("select users.name, min(orders.summa) sum "
				+ "from users,orders where users.id = orders.user_id group by users.name "
				+ "having sum > (select avg(orders.summa) from orders);");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getInt(2));
		}*/
			
		/*Задача 14. Отобразить пользователей, у которых максимальная сумма заказа
 		меньше чем среднее по всем заказам.
		ResultSet rs = statement.executeQuery("select users.name, max(orders.summa) as sum "
				+ "from users,orders "
				+ "where users.id = orders.user_id "
				+ "group by users.name "
				+ "having sum < (select avg(orders.summa) from orders);");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getInt(2));
		}*/
		
		/*Задача 15. Отобразить заказы, у которых сумма заказа больше
 		чем среднее арифметическое всех заказов.
		ResultSet rs = statement.executeQuery("select orders.number, orders.summa "
				+ "from orders "
				+ "where orders.summa >(select avg(orders.summa) from orders);");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getInt(2));
		}*/
		
		/*Задача 16. Отобразить имена Заказчиков и их общую сумму по заказам.
		(имя заказчика и общую сумму по его заказам)
		ResultSet rs = statement.executeQuery("select users.name, sum(orders.summa) as summa "
				+ "from users, orders "
				+ "where users.id=orders.user_id group by users.name;");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getInt(2));
		}*/
		
		/*Задача 17. Вывести общую сумму заказов каждого заказчика, 
		у которых эта общая сумма больше маскимального заказа(из всех)
		ResultSet rs = statement.executeQuery("select users.name, sum(orders.summa) "
				+ "from users, orders "
				+ "where users.id=orders.user_id "
				+ "group by users.name "
				+ "having sum(orders.summa) > (select max(orders.summa) from orders);");
		while(rs.next()){
			System.out.println(rs.getString(1) + ", " + rs.getInt(2));
		}*/
		
		statement.close();
		connection.close();
	}
}
