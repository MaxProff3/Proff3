package action05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
//Task1
public class Task1 {
	public static void main(String[] args) {
		String str = new String();
		Class<?> c2 = str.getClass();
		
		Method[] methods = c2.getMethods();
//		c2.getMethods();
		Set<String> set = new TreeSet();
		for(int i = 0; i < methods.length; i++) {
			set.add(methods[i].getClass().getSimpleName());
		}
		for(String i : set) {
			System.out.println(i);
		}
	}
	//Task2
	public static ArrayList<Method> anyClass(Class<?> c) {
		
		Class<?> c1 = c.getClass();
		c.getMethods();
		ArrayList<Method> list = new ArrayList<>();
		for(int i = 0; i < list.size(); i ++) {
			
		}
		return null;
		
	}
		
		
		

}
