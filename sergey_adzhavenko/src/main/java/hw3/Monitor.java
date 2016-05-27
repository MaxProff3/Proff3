package hw3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Monitor {
	public static void main(String[] args) {
		OrgonizeThreads.th1.start();
		OrgonizeThreads.th2.start();
	}
}

class OrgonizeThreads {
	static File nameFile1 = new File("nameFile1.txt");
	static File nameFile2 = new File("nameFile2.txt");
	static ThreadCreator th1 = new ThreadCreator();
	static ThreadWriter th2 = new ThreadWriter();
}

class ThreadCreator extends Thread {
	
	FileWriter fw;
	Scanner scan = new Scanner(System.in);
	String str = "";

	@Override
	public void run() {
		while (!str.equals("exit")) {
			try {
				System.out.println("Put something:");
				str = scan.next();
				fw = new FileWriter(OrgonizeThreads.nameFile1);
				fw.write(str);
				fw.close();
				synchronized(OrgonizeThreads.th2){
					OrgonizeThreads.th2.notify();
				}	
			} catch (Exception e) {e.printStackTrace();}
		}
	}
}

class ThreadWriter extends Thread {
	
	FileReader fr;
	FileWriter fw;
	Scanner scan;
	String str;

	@Override
	public void run() {
		synchronized(this){
			while(true){
				try {
					this.wait();
					fr = new FileReader(OrgonizeThreads.nameFile1);
					scan = new Scanner(fr);
					str = "";
					while (scan.hasNextLine())
						str = str + scan.nextLine();
					fw = new FileWriter(OrgonizeThreads.nameFile2);
					fw.write(str);
					fw.close();	
					
				} catch (Exception e) {e.printStackTrace();}
				if(!OrgonizeThreads.th1.isAlive())break;
			}			
		}
	}
}
