package action06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ThreadCreator extends Thread {

	@Override
	public void run()  {
		Synchrinized scObj = new Synchrinized ();
File f = new File("D:"+File.separator+"work"+File.separator+"Cources"+File.separator+"nameFile1.txt");
if(f.exists()){
	
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	try {
		String s=reader.readLine();
		FileWriter fw= new FileWriter(f);
		while(!s.equals("exit")){
			fw.write(s);
			s="";
			s=reader.readLine();
			scObj.nitifyMy();
		}	
		fw.close();
		Thread.currentThread().interrupt();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
				
	}
	

}