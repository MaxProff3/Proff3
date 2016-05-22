package action05;

/*Задача2:(ReflectionTask2Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект.
 */
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task2 {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		Class aclass = a.getClass();
		Class c = LinkedList.class;
		Class[] cla = c.getDeclaredClasses();
		for (Class cl : cla) {
			System.out.println(cl.getSimpleName());
		}

	}

}
