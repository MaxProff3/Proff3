
package action06;
/*
 Написать класс Monitor(nameFile1,nameFile2), в котором два потока.

1. Поток 1(ThreadCreator), считывает строку с консоли записывает в nameFile1, 
 будит поток 2.(objSynchro.notify())
 
2. Поток 2(ThreadWriter), копирует nameFile1 в nameFile2 и засыпает. 
 (objSynchro.wait()) 

Примечание: 
1. если с консоли введено слово "exit" или "quit", то поток №1 останавливать.
2. продумать остановку и второго потока. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Monitor {
	ThreadCreator thread1;
	ThreadWriter thread2;

	public Monitor() {
		this.thread1 = new ThreadCreator();
		this.thread2 = new ThreadWriter();

	}

	class ThreadCreator extends Thread {
		String str = "";
		Scanner scan = new Scanner(System.in);;
		File file = new File("nameFile1");
		FileWriter fw;

		@Override
		public void run() {
			while (!str.equals("exit") && !str.equals("quit")) {
				try {
					System.out.println("Input text");
					str = scan.nextLine();
					fw = new FileWriter(file);
					fw.write(str);
					fw.close();

				} catch (IOException e) {
					System.out.println("NOT FILE");
					e.printStackTrace();
				}
				synchronized (thread2) {
					thread2.notify();
				}
			}
			scan.close();
			System.out.println("First END");
		}
	}

	class ThreadWriter extends Thread {

		public void run() {
			synchronized (this) {
				try {
					this.wait();
					System.out.println("Second run");
					File file1 = new File("nameFile1");
					File file2 = new File("nameFile2");
					FileReader fr = new FileReader(file1);
					Scanner scan = new Scanner(fr);
					String str = "";
					while (scan.hasNext()) {
						str = scan.nextLine();
					}
					try {
						FileWriter fw = new FileWriter(file2);
						fw.write(str);
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					System.out.println("Second sleep");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}