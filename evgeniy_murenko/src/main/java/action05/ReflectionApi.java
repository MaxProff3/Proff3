package action05;

import java.lang.reflect.*;

public class ReflectionApi {

	public static void main(String[] args) {
		ReflectionApi obj = new ReflectionApi();
		Class<?> cl = obj.getClass();

		Field[] fields = cl.getFields(); // получение всех полей

		cl.getDeclaredFields();

		Method[] methods = cl.getMethods();// получение всех доступных методов
		cl.getDeclaredMethods(); // тоже самое ток и методов с прайвед, все

		cl.getInterfaces(); // ìîæåò áûòü íåñêîëüêî îäèíàêîâûõ
		cl.getSuperclass();

		methods[0].isAnnotationPresent(MyAnnotation.class);

		
		
	}

}