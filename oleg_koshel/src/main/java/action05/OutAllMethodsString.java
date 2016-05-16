package action05;

import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class OutAllMethodsString {
	
	public static void main(String[] args) {
		
		
		String obj = new String();
		Class<?> cl = obj.getClass();
		
		
		Method[] methods = cl.getDeclaredMethods();
	
		
		for (Method m:methods){
			
			System.out.println(m.toString());
			
		}
		
		
	}

}
