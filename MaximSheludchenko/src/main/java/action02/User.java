/*������� ������ Base, User,MainBase
 - Base(Set<User>) 
 - User(String login, String pass)
� ������������ Base �������� ��������� �������������.
� ����� Base �������� ����� 
 boolean auth(String login, String pass)
� ������� ������ MainBase ������� ������ ������ Base � ������� ������� ����� � ������, ���������� ���� �� ����� ������������.

2. �������� � ����� �����, ����� ���������: User(name, login, pass, dateOfExpire)
� ����� Base �������� �����
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
