package action05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ReflectionTask2Example {

	public static void OutClassesOfObject(Class<?> cl) {

		HashSet<String> hs = new HashSet<String>();

		ArrayList<Class<?>> arr = new ArrayList<Class<?>>();

		arr.add(cl);

		for (Class<?> el : arr) {
			
			if (el.getSuperclass()!=Object.class){
				
				arr.add(el.getSuperclass());

				hs.add(el.getSuperclass().toString());
				
			}



		}
		
		
		Iterator iterator =  hs.iterator();
		
		while (iterator.hasNext()){
			
			System.out.println(iterator.next());
			
		}

	}

}
