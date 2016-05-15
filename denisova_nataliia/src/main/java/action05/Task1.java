package action05;
/*Задача1: Вывести все методы класса String*/

import java.lang.reflect.Method;

public class Task1 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String str = new String();
		Class<?> cl = str.getClass();//получаем класс
//		String str1 = (String)cl.newInstance();//создаем объект этого класса
		
		Method[] methods = cl.getMethods();
		
		for(int i = 0; i < methods.length; i++){
			System.out.println(methods[i]);
		}
	}
}
