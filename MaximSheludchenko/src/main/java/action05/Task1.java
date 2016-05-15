/*Вывести все методы класса String*/
package action05;

import java.lang.reflect.Method;

public class Task1 {
	public static void main(String[] args) {
		String str = "0";
		Class<?> cl = str.getClass();
		Method[] metodString = cl.getMethods();
		
		for(Method met: metodString){
			System.out.println(met);
		}
		
	}
}
