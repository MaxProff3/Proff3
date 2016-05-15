package action05;

/*Задача2:(ReflectionTask2Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект.
 */
import java.lang.reflect.*;
import java.util.LinkedList;

public class Task2 {

	public static void main(String[] args) {
		String a = new String();
		Class aclass = a.getClass();
		Class c = LinkedList.class;
		Class[] cla = c.getDeclaredClasses();
		for (Class cInterface : cla) {
			System.out.println(cInterface.getName());
		}

	}

}
