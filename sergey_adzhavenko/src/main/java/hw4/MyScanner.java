package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyScanner {

	private BufferedReader buffer;
	
	public MyScanner(InputStream inputStream){
		buffer = new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public MyScanner(FileReader fileReader) {
		buffer = new BufferedReader(fileReader);
	}
	
	public String next(){
		StringBuilder sb = new StringBuilder();
		try {
			int nextChar = buffer.read();
			boolean hasChar=false;
			while(hasChar==false){
				while(nextChar!=-1){
					if(hasChar==false){
						if(nextChar==32 || nextChar==13 || nextChar==10)buffer.skip(1);
					}
					if(nextChar!=32 && nextChar!=13 && nextChar!=10){
						hasChar=true;
						sb.append((char)nextChar);
					}
					if(hasChar==true){
						if(nextChar==32 || nextChar==13 || nextChar==10)break;
					}
					nextChar=buffer.read();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public boolean hasNext() {
		try {
			buffer.mark(1);
			if(buffer.read()!=-1){
				buffer.reset();
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String nextLine(){
		String str = null;
		try {
			str = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public boolean hasNextLine() {
		try {
			buffer.mark(1);
			if(buffer.read()!=-1){
				buffer.reset();
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int nextInt(){
		return Integer.parseInt(next());
	}

	public boolean hasNextInt(){
		try{
			buffer.mark(1);
			Integer.parseInt(next());
			buffer.reset();
			return true;
		}catch (Exception e) {
		}
		return false;
	}
	
	public double nextDouble() {
		return Double.parseDouble(next());
	}
	
	public boolean hasNextDouble() {
		try{
			buffer.mark(1);
			Double.parseDouble(next());
			buffer.reset();
			return true;
		}catch (Exception e) {
		}
		return false;
	}
	
	public void close(){
		try {
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
