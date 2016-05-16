package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionApi {

	public static void main(String [] args){
		ReflectionApi obj = new ReflectionApi();
		Class<?> cl =  obj.getClass();
		
		Field[] fields  = cl.getFields();
		cl.getDeclaredFields();
		Method[] metods =  cl.getMethods();
		cl.getDeclaredMethods();
		cl.getInterfaces();
		cl.getSuperclass();
		
	}
}
	