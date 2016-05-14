package action05;

import java.util.LinkedList;

/*Задача3:(ReflectionTask3Example) 
 Написать метод, принимающий любой объект, 
 выводящий список всех интерфейсов по иерархии наследования классов.*/

public class Task3 {

	public static void main(String[] args) {
		String a = new String(); 
		Class aclass = a.getClass(); 
		Class c =  LinkedList.class; 
		Class[] interfaces = c.getInterfaces(); 
		for(Class cInterface : interfaces) { 
		    System.out.println( cInterface.getName() ); 
		} 
	}

}
