package action08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class MyScanner {
	public static void main(String[] args) throws Exception {
		
		Reader system = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(system);
		
		int a = buff.read();
		System.out.println(a);
		int d =(int)'7';
		System.out.println(d);
//		String str = buff.readLine();
//		System.out.println(str);
		
		//
//		Scanner scan = new Scanner(System.in);
//		
//		if(scan.hasNextInt()){
//			int k1 = scan.nextInt();
//			System.out.println("1, k1="+k1);
//		}
//		if(scan.hasNextInt()){
//			int k2 = scan.nextInt();
//			System.out.println("2, k2="+k2);
//		}
//		
//		System.out.println(scan.nextLine());
		//System.out.println(scan.nextLine());
	}
}