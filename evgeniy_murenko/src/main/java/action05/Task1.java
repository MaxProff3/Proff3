package action05;

/*Задача1: Вывести все методы класса String*/
import java.lang.reflect.*;

public class Task1 {

	public static void main(String[] args) {
		String str = new String();
		Class<?> cl = str.getClass();

		Method[] m = cl.getMethods();
		for (Method md : m) {

			System.out.println(md.getName());
		}

	}

}
