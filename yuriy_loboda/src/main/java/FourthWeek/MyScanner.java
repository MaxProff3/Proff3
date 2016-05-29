package FourthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MyScanner {
	BufferedReader reader;
	
	MyScanner(InputStream is){
		Reader read = new InputStreamReader(is);
		reader = new BufferedReader(read);
	}
	
	
	public String next() throws IOException{
		String s="";
		int ch;
		while((ch=reader.read())!=-1){
			
			if (ch!=32 && ch!=10 && ch!=13){	
			s+=(char)ch;
			}
			if(ch==32 && s.equals("")){
				continue;
			}
			if(ch==32 ||ch==10 ||ch==13){
				return s;
			}
			
			}
		return s;   
		}
	
	public String nextLine() throws IOException{
		int ch ;
		StringBuilder sb =new StringBuilder();
		sb=null;
		while((ch=reader.read())!=-1){
			if(ch!=10 || ch!=13){
			sb.append((char) ch);	
			}
			if(ch==10 || ch==13){
				System.out.println(ch);
				return sb.toString();
			}
			
		}
		return sb.toString();
	}
	

	public int nextInt() throws NumberFormatException, IOException{
		int i = 0;
		try{
		 i= Integer.parseInt(this.next()); 
	}catch(NumberFormatException e){
		System.out.println("не корректные данные -");
	}
		
		return i;
	}
	
	public Double nextDouble() throws NumberFormatException, IOException{
		Double i =  0d;
		try{
		 i= Double.parseDouble(this.next()); 
	}catch(NumberFormatException e){
		System.out.println("не корректные данные -");
	}
		
		return i;
	}
	
}

		 	
		

