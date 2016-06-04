package action06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ThreadWriter extends Thread {
	
	@Override
	public void run()  {
		Synchrinized scObj = new Synchrinized ();		
File f = new File("D:"+File.separator+"work"+File.separator+"Cources"+File.separator+"nameFile1.txt");
File f1= new File("D:"+File.separator+"work"+File.separator+"Cources"+File.separator+"nameFile2.txt");
			if(f1.exists()){
				try {
					Scanner sc=new Scanner(f);
					FileWriter fw = new FileWriter(f1);
					String s="";
			
					while(sc.hasNext()){	
					//	System.out.println(sc.next());
						s=sc.next();
						fw.write(s);
						scObj.waitMy();
					}
					sc.close();
				    fw.close();
				  
				//	Thread.interrupted();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
}
