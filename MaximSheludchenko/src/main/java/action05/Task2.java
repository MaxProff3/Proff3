/*Задача2:(ReflectionTask2Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект.*/
package action05;

import java.util.ArrayList;

public class Task2 {
	public static void main(String[] args) {

		// ArrayList<String> obj = new ArrayList<>();
		// Class<?> cl = obj.getClass();
		// System.out.println(cl.getSuperclass().getSimpleName());
		// System.out.println(cl.getSuperclass().getSuperclass().getSimpleName());
		// System.out.println(cl.getSuperclass().getSuperclass().getSuperclass().getSimpleName());
		// System.out.println(cl.getSuperclass().getSuperclass().getSuperclass().getSuperclass());

		getAllClasses(new ArrayList().getClass());
	}

	public static void getAllClasses(Class<?> obj) {		
		if (obj != null) {
			System.out.print(obj.getSimpleName() + "-> ");
			getAllClasses(obj.getSuperclass());
		}

	}

}
