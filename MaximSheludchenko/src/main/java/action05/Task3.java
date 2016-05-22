/*Задача3:(ReflectionTask3Example) Написать метод, принимающий любой объект, 
выводящий список всех интерфейсов по иерархии наследования классов.*/
package action05;

import java.util.ArrayList;

public class Task3 {
	public static void main(String[] args) {
//		System.out.println("2".getClass().getSuperclass().getName());
//		Class<?>[] cla = "2".getClass().getInterfaces();
//		for(Class<?> classes: cla) System.out.println(classes.getName());
		getAllInterface("1".getClass());
	}
	
	public static void getAllInterface(Class<?> obj){
		for(Class<?> cla: obj.getInterfaces()){
			System.out.println(cla.getName());
		}
		if(obj.getSuperclass() != null){
			getAllInterface(obj.getSuperclass());
		}
		
	}
}
