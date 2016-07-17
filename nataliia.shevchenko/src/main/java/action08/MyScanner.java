package action08;

import java.io.IOException;
import java.util.Scanner;

public class MyScanner {
	public static void main(String[] args) throws IOException {
		/*
		Reader system = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(system);
		String str = buff.readLine();
		System.out.println(str);
		*/
		//
		Scanner scan = new Scanner(System.in);
		/*
		if(scan.hasNextInt()){
			int k = scan.nextInt();
			System.out.println("1");
		}
		if(scan.hasNextInt()){
			int k = scan.nextInt();
			System.out.println("2");
		}
		*/
		System.out.println(scan.nextLine());
		System.out.println(scan.nextLine());
	}

}
