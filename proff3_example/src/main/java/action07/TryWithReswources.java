package action07;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithReswources {
	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			fw = new FileWriter("file1.txt");
			fw.write("hello");
			fw.write(" world!"); 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw!=null)fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void run() {
		try (FileWriter fw = new FileWriter("file1.txt");){
			fw.write("hello");
			fw.write(" world!");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("errror");
		}		
	}	
}
