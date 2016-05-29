package homeWork4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 1. Написать свой класс MyScanner, который бы работал также как и стандартный
класс Scanner. 
Реализовать методы: next, nextInt, nextDouble, nextLine
hasNext, hasNextLine, hasNextInt, hasNextDouble.
 */

public class MyScanner {
	private BufferedReader buff;

	public MyScanner(InputStream in) {
		buff = new BufferedReader(new InputStreamReader(in));
	}

	public String next() {
		String str = "";
		int charInt;
		boolean isWord = true;
		try {
			while (isWord) {
				charInt = buff.read();
				if (charInt == 32 || charInt == 13) {
					isWord = false;
				} else {
					str += (char) charInt;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public Integer nextInt() {
		return Integer.parseInt(next());
	}

	public Double nextDouble() {
		return Double.parseDouble(next());
	}

	public String nextLine() {
		String str = null;
		try {
			str = buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public boolean hasNext() {
		boolean isChar = true;
		int charInt;
		while (isChar) {
			try {
				charInt = buff.read();
				if (charInt > -1 && ( charInt != 32 || charInt != 13)) {
					isChar = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean hasNextLine() {
		try {
			if (buff.read() != -1) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean hasNextInt(){
		try {
			Integer.parseInt(next());
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	public boolean hasNextDouble(){
		try {
			Double.parseDouble(next());
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	
}
