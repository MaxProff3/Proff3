package FourthWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MyScanner {
	BufferedReader reader;
	private int flag ;
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
		String s="";
		StringBuilder sb =new StringBuilder();
		while((ch=reader.read())!=-1){
			if(ch!=13 && ch!=10){
			sb.append((char)ch);	
			}
			if(ch==13){
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
		/*NOP*/
	}
		
		return i;
	}
	
	public Double nextDouble() throws NumberFormatException, IOException{
		Double i =  0d;
		try{
		 i= Double.parseDouble(this.next()); 
	}catch(NumberFormatException e){
		/*NOP*/
	}
		
		return i;
	}
	
	public boolean hasNext() throws IOException{
		reader.mark(1);
		if(reader.read()!=-1){
			reader.reset();
			return true;
		}
			return false;
}
	public boolean hasNextLine() throws IOException{
		reader.mark(1);
		if(reader.readLine()!=null){
			reader.reset();
			return true;
		}
			return false;
}
	public boolean hasNextInt() throws IOException{
		reader.mark(1);
		if(reader.read()!=-1){
			Integer.parseInt(next());
			reader.reset();
			return true;
		}
			return false;
}	
}		

