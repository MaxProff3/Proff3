/*Создать классы Base, User,MainBase
 - Base(Set<User>) 
 - User(String login, String pass)
В конструкторе Base добавить несколько пользователей.
В класс Base добавить метод 
 boolean auth(String login, String pass)
В главном классе MainBase создать объект класса Base с консоли считать логин и пароль, определить есть ли такой пользователь.
*/package action02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Base {
	Set<User> users= new HashSet();
	
	public Base(){
		users.add(new User("ivan","111"));
		users.add(new User("petro","222"));
		users.add(new User("natasha","218963"));
		}

	public Set<User> getBase() {
		return users;
	}

	public void setBase(Set<User> base) {
		this.users = users;
	}
	
	public boolean auth(String login, String pass){
		Iterator<User> iter = users.iterator();
		User obj;
		while(iter.hasNext()){
			obj = iter.next();
			if(obj.getLogin().equalsIgnoreCase(login)&&obj.getPass().equals(pass))return true;
		}
		return false;
	}
	
	
}
