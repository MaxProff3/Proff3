package action06;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Написать класс Monitor(nameFile1,nameFile2), в котором два потока.

1. Поток 1(ThreadCreator), считывает строку с консоли записывает в nameFile1, 
 будит поток 2.(objSynchro.notify())
 
2. Поток 2(ThreadWriter), копирует nameFile1 в nameFile2 и засыпает. 
 (objSynchro.wait()) 

Примечание: 
1. если с консоли введено слово "exit" или "quit", то поток №1 останавливать.
2. продумать остановку и второго потока.*/

public class Monitor {
	public static void main(String[] args) {
		ThreadCreator creator = new ThreadCreator();
		ThreadWriter writer = new ThreadWriter();
		
		creator.start();
		//writer.start();
	}
}

class ThreadCreator extends Thread {
	@Override
	public void run(){
		try {
			Scanner scan = new Scanner(System.in);
			FileWriter fw = new FileWriter("nameFile1");
			System.out.println("Введите строку для записи в файл: ");
			String str = scan.nextLine();
			fw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ThreadWriter extends Thread {
	@Override
	public void run(){
		for (int i = 0; i < 2000; i++) {
			System.out.println(getName() + "_" + i);
		}
	}
}
