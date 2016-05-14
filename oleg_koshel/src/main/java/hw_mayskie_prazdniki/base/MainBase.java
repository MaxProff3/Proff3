package hw_mayskie_prazdniki.base;

import java.io.IOException;
import java.text.ParseException;
import java.util.GregorianCalendar;

public class MainBase {
	
	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
		
//		String fileName = "C:\\1\\Users.txt";

// Test add
//		
		GregorianCalendar dateOfExpireUser1 = new GregorianCalendar(1975,12, 31);
		User user1 = new User("����","111","����",dateOfExpireUser1);
	
		GregorianCalendar dateOfExpireUser2 = new GregorianCalendar(1900,11, 20);
		User user2 = new User("Ulia","222","����",dateOfExpireUser2);
//			
//		System.out.println(user1);
//		System.out.println(user2);
//			
		Base.add(user1);
		Base.add(user2);
//		
//		System.out.println(Base.auth("����", "111"));
		
		
		
		
//		
// Test usersToFile
//		Base.usersToFile(fileName);
		
		
		
// Test	usersFromFile	
		
//	User[] users = Base.usersFromFile(fileName);
		
		String fileName = "C:\\1\\UserSER.txt";	
		
		Base.usersSerializeToFile(fileName);
		
		User[] users = Base.usersDeSerializeFromFile(fileName);
		
		for (User u:users){
			
			System.out.println(u);
		}
		
	}

}
