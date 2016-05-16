  /*Создать классы Base, User,MainBase
 - Base(Set<User>) 
 - User(String login, String pass)
В конструкторе Base добавить несколько пользователей.
В класс Base добавить метод 
 boolean auth(String login, String pass)
В главном классе MainBase создать объект класса Base с консоли считать логин и пароль, определить есть ли такой пользователь.
*/
package action02;

import java.util.Scanner;

public class MainBase {
	public static void main(String[] args) {
		//
		String s1 = "ab";
		String s2 = "ab";
		String s3 = new String("ab");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		Base base = new Base();
		Scanner scan = new Scanner(System.in);
		System.out.println(" Введите логин искомого пользователя: ");
		String login = /*"ivan";*/scan.nextLine();
		System.out.println(" Введите пароль искомого пользователя: ");
		String pass = /*"111";*/scan.nextLine();
		if(base.auth(login, pass)){System.out.println("yes");}
		else {System.out.println("no");}
	}
}
