package action05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReflectionTask2 {
	public static List<Class<?>> getAllClasses(Object obj ){
		List<Class<?>> list = new ArrayList<>();
		list.add(obj.getClass());
		list = getAllClasses(list,0);
		return list;
	} 
	public static List<Class<?>> getAllClasses(List<Class<?>> list, int i){
		if(list==null) return null;
		Class<?> p = list.get(i).getSuperclass();
		list.add(p);
		if(p!=null && i+1<list.size())getAllClasses(list, i+1);
		return list;		
	}
	public static void main(String[] args) {
		System.out.println(getAllClasses(new HashMap()));
	}
}
