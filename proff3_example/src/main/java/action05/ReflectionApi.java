package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import action04.Car;

public class ReflectionApi {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectionApi obj = new ReflectionApi();

		Class<?> cl = obj.getClass();//cl ������ ���1 obj
 
		ReflectionApi obj1 = (ReflectionApi)cl.newInstance();

		
		Field[] fields = cl.getFields();
		cl.getDeclaredFields();
		
		Method[] methods = cl.getMethods();
		cl.getDeclaredMethods();
		
		cl.getInterfaces();  //����� ���� ��������� ����������
		cl.getSuperclass();
		
		methods[0].isAnnotationPresent(MyAnnotation.class);
 	}	
}
