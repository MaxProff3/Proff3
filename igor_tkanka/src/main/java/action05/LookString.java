package action05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LookString {

	public static void main(String[] args) {

		Class<?> strcl = String.class;

		// Field[] fields = cl.getFields();
		// cl.getDeclaredFields();

		Method[] methods = strcl.getMethods();
		// cl.getDeclaredMethods();

		// for (int i=0;i<methods.length;i++)System.out.println(methods[i]);
		// cl.getInterfaces();
		// cl.getSuperclass();

		printInterfaces(new ArrayList());

	}

	public static <T> void printInterfaces(T obj) {
		Class<?> objClass = obj.getClass();
		
		Set interfaces=new HashSet<String>();
		printInterfaces(objClass,interfaces);
		
		for (Iterator iterator = interfaces.iterator(); iterator.hasNext();) {
			Object i = iterator.next();
			System.out.println(i);
		}
		
	}
	
	public static void printInterfaces(Class objClass,Set interfases) {
	
		Class<?>[] inter = objClass.getInterfaces();
		
		System.out.println("_______________________________________");
		System.out.println(objClass.getName());
		System.out.println("_______________________________________");
		
		for (Class<?> element : inter) {
			System.out.println(element.getName());
			interfases.add(element.getName());
		}
		
		Class<?> objSuper = objClass.getSuperclass();
		if (objSuper != null) {
			
			printInterfaces(objSuper,interfases);
		}

	}
}
