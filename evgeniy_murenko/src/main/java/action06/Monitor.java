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
	MyThread1 thread1;
	MyThread2 thread2;

	public Monitor() {
		this.thread1 = new MyThread1();
		this.thread2 = new MyThread2();

	}

	class MyThread1 extends Thread {
		@Override
		public void run() {
			synchronized (this) {
				System.out.println("Input text");
				Scanner scan = new Scanner(System.in);
				boolean isLine = true;
				String str = "";
				while (isLine) {
					if (scan.hasNextLine()) {
						str += scan.nextLine();
						isLine = false;
					}
				}
				File file = new File("nameFile1");
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(str);
					fw.close();
				} catch (IOException e) {
					System.out.println("NOT FILE");
					e.printStackTrace();
				}
				try {
					super.notifyAll();
					this.wait();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class MyThread2 extends Thread {

		public void run() {
			synchronized (this) {
				try {
					System.out.println("Second wait");
					this.wait();
					System.out.println("Second run");
					File file1 = new File("nameFile1");
					File file2 = new File("nameFile1");
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

				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("Good");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}