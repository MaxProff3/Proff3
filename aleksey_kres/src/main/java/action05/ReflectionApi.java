package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApi {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectionApi obj = new ReflectionApi();
		Class<?> c1 = obj.getClass();
		ReflectionApi obj1 = (ReflectionApi)c1.newInstance();
		
		Field[] fields = c1.getFields();
		c1.getDeclaredFields();
		
		Method[] methods = c1.getMethods();
		c1.getDeclaredMethods();
		
		c1.getInterfaces();
		c1.getSuperclass();
	}

}
