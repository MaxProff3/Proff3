/*Задача2:(ReflectionTask2Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект.*/
package action05;

public class Task2 {
	public static void main(String[] args) {
		String obj = "123";
		getAllClasses(obj);
	}
	
	public static <T> void getAllClasses(T obj){
		Class<?> cla = obj.getClass();
		
	}

}
