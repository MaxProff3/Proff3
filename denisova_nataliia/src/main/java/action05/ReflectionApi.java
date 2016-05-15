package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApi {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectionApi obj = new ReflectionApi();

		Class<?> cl = obj.getClass();//cl хранит тип1 obj

		ReflectionApi obj1 = (ReflectionApi)cl.newInstance();

		
		Field[] fields = cl.getFields();
		cl.getDeclaredFields();
		
		Method[] methods = cl.getMethods();
		cl.getDeclaredMethods();
		
		cl.getInterfaces();  //может быть несколько одинаковых
		cl.getSuperclass();
		
		methods[0].isAnnotationPresent(MyAnnotation.class);
 	}	
}
