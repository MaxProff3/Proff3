package action07;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
	public static void main(String[] args) {
		//this is usually record of the 'Try-Catch' block 
		FileWriter fw;
	try{		
		fw = new FileWriter ("file1.txt");
		fw.write("Hi");
		fw.write("world");
	}catch (IOException e){
		e.printStackTrace();
		
	}
	}
// and now we rewrite above expression using Try-Catch with resource 
	// the row which is committed in the below text, it has name "заглушка". 
}
