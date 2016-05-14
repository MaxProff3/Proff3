package hw2;

import java.util.Scanner;

public class MainBase {

	public static void main(String[] args) throws Exception {
		  
		Base base = new Base();
		
		String log = "log.txt";
		base.usersToFile(log);
		User[] userLog = base.usersFromFile(log);
		for(User a: userLog){
			System.out.println(a.toString());
		}
		
		String fileName = "users.base";
		base.usersSerializeToFile(fileName);
		User[] users = base.usersDeSerializeFromFile(fileName);
		for(User a: users){
			System.out.println(a.getLogin());
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Login:");
		String login = scan.nextLine();
		System.out.println("Password:");
		String pass = scan.nextLine();
		base.auth(login, pass);
		
	}

}
