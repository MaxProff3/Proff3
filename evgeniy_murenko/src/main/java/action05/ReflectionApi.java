package action05;

import java.lang.reflect.*;

public class ReflectionApi {

	public static void main(String[] args) {
		ReflectionApi obj = new ReflectionApi();
		Class<?> cl = obj.getClass();
		
		Field[] fields = cl.getFields(); //получение всех полей
		
		cl.getMethods(); // получение всех доступных методов 
		cl.getDeclaredMethods(); // тоже самое ток и методов с прайвед, все текущее и открытые родителя
	}

}