package hwAction08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyScanner extends Thread {
	
	private BufferedReader bfr;	
	private InputStreamReader isr;
	
	
	public MyScanner(){
		run();		
	}
	
	
	@Override
	public void run(){
		
		isr = new InputStreamReader(System.in);
		bfr = new BufferedReader(isr);
		
		while(true){
			
			try {
				String s = bfr.readLine();
				
				System.out.println(s);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	
	public boolean hasNextInt(){
		
		System.out.println("hasNex");
		
		return true;
				
	}
	
	public int nextInt(){
		
		return 0;
	}

}
