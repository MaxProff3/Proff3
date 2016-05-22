package action06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreadCreator extends Thread {
	@Override
	public void run(){
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		try {
			String s1="exit";
			String s2="quit";
			String s=reader.readLine();
			File f=new File("D:"+File.separator+"work"+File.separator+"Cources"
					+File.separator+"nameFile1.txt");
			if(f.exists()){
				FileWriter fw= new FileWriter(f);
				while(!s.equals(s1) || !s.equals(s2)){
					fw.write(s);
					s=reader.readLine();
					if(isInterrupted()){break;}
				}
				fw.close();
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
