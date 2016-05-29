package hwAction08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) {
		
		
		
	}
	

	class sendClien extends Thread{
		
		Scanner sc;
		
		@Override
		public void run(){
			
			sc = new Scanner(System.in);
			
			String str;
			int numberClient;
			
			if (sc.hasNextInt()){
				
				numberClient = sc.nextInt();
				
			}	
			
			if (sc.next() != null){
				
				str = sc.next();
			}
			
			
		}
		
		
	}


	class Clien {
		
		String nameClient;
	}
	
}



