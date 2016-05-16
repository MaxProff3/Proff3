package action5;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*Задача1: Вывести все методы класса String

Задача2:(ReflectionTask2Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект.
 
Задача3:(ReflectionTask3Example) Написать метод, принимающий любой объект,
 выводящий список всех интерфейсов по иерархии наследования классов.*/
public class ReflectionApi {

	public static void main(String[] args) {

		String s = new String();
		Class<?> c = s.getClass();
//		
//		Method[] m = c.getMethods();
//		
//		for(int i =0; i<m.length;i++){
//			System.out.println(m[i]);
//		}
//		ArrayList<Method> list = new ArrayList<>();
//		list = anyClass(c.getClass());
//		for(int i =0; i<list.size();i++){
//			System.out.println(list.get(i));;
//		}
		ArrayList<String> list = new ArrayList<>();
		Class<?> classs = list.getClass();
		allInterfasec(classs);
		
	}
	
	public static ArrayList<Method> anyClass(Class<?> c){
		Class<?> cl = c.getClass();
		Method[] m = cl.getMethods();
		ArrayList<Method> list = new ArrayList<>();
		for(int i =0; i<m.length;i++){
			list.add(m[i]);
		}
		
		return list;
		
	}
	
	public static void allInterfasec(Class<?> c){

		Class<?> superCl = c.getSuperclass();
		
		//System.out.println(c.getSuperclass());
		
		Class<?>[] r = superCl.getInterfaces();
		Set<Class<?>> set = new HashSet<>();
		for(int i =0; i<r.length;i++){
			set.add(r[i]);
		}
		System.out.println(set);
		//System.out.println(r.length);
	}

}
interface f{
	
}
class Animal implements f{
	
}
class Cat extends Animal{
	
}
