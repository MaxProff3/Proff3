package action05;

import java.util.ArrayList;
import java.util.HashMap;


public class ReflectionTask2Example {

	public static void OutClassesOfObject(Object obj) {

		

		ArrayList<Class<?>> arr = new ArrayList<Class<?>>();

		arr.add(obj.getClass());
		
		
		
		for (int i=0;i<arr.size();i++){
			
			
			Class<?> el = arr.get(i);
			
			if (el!=null) {
				arr.add(el.getSuperclass()) ;
				System.out.println(el.getSuperclass());
			}
						
		}
				

	}

	
	public static void main(String[] args) {
		OutClassesOfObject(new ArrayList());
	}
}
