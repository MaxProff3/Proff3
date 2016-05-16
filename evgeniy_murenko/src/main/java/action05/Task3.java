package action05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

/*Задача3:(ReflectionTask3Example) 
 Написать метод, принимающий любой объект, 
 выводящий список всех интерфейсов по иерархии наследования классов.*/

public class Task3 {

	public static void main(String[] args) {

		Class c = TreeMap.class;
		Class[] cl = c.getDeclaredClasses();

		HashSet<Class> set = new HashSet();
		for (Class cl1 : cl) {
			System.out.println(cl1.getSimpleName());
			Class temp = cl1;
			while(cl1 != null){
				System.out.println(temp.getSuperclass().getSimpleName());
				temp = temp.getSuperclass();
			}
			
			
		}
	}

}
