/*Создать классы Base, User,MainBase
 - Base(Set<User>) 
 - User(String login, String pass)
В конструкторе Base добавить несколько пользователей.
В класс Base добавить метод 
 boolean auth(String login, String pass)
В главном классе MainBase создать объект класса Base с консоли считать логин и пароль, определить есть ли такой пользователь.

2. Добавить в класс полей, чтобы получилсь: User(name, login, pass, dateOfExpire)
В класс Base добавить метод
 - void usersToFile(String fileName)
 - User[] usersFromFile(String fileName)
 - void usersSerializeToFile(String fileName)
 - User[] usersDeSerializeFromFile(String fileName)

*/package action02;

public class User {
	String login;
	String pass;
	String name;
	

	@Override
	public String toString() {
		return "User [login=" + login + ", pass=" + pass + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User(String login, String pass) {
		//super();
		this.login = login;
		this.pass = pass;
	}

}
