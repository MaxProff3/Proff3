package action05;
/*Задача2:(ReflectionTask2Example) 
 * Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых 
 входит данный объект.*/
public class Task2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String str = new String("my obj");
		backObj(str);
	}
	
	public static <T> void backObj(T obj) throws InstantiationException, IllegalAccessException{
		Class<?> cl = obj.getClass();
		
		
		System.out.println(cl.getInterfaces());
		
	}
}
