  /*������� ������ Base, User,MainBase
 - Base(Set<User>) 
 - User(String login, String pass)
� ������������ Base �������� ��������� �������������.
� ����� Base �������� ����� 
 boolean auth(String login, String pass)
� ������� ������ MainBase ������� ������ ������ Base � ������� ������� ����� � ������, ���������� ���� �� ����� ������������.
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
		System.out.println(" ������� ����� �������� ������������: ");
		String login = /*"ivan";*/scan.nextLine();
		System.out.println(" ������� ������ �������� ������������: ");
		String pass = /*"111";*/scan.nextLine();
		if(base.auth(login, pass)){System.out.println("yes");}
		else {System.out.println("no");}
	}
}
