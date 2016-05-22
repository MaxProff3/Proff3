/*Задача2:(ReflectionTask2Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект.*/
package action05;

import java.util.ArrayList;

public class Task2_1 {
	public static void main(String[] args) {

		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(new ArrayList<>().getClass());
		list = getAllClasses(0, list);
		System.out.println(list);
	}

	public static ArrayList<Class<?>> getAllClasses(int i, ArrayList<Class<?>> list) {
		if (list.get(i).getSuperclass() != null && i < 10) {
			Class<?> cla = list.get(i).getSuperclass();
			list.add(cla);
			getAllClasses(i + 1, list);
		}
		return list;
	}

}
