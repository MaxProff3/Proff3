package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class ReflectionTask3 {
	
	public static void OutInterfacesOfObject(Object obj) {
		
		
		ArrayList<Class<?>> arr = new ArrayList<Class<?>>();

		arr.add(obj.getClass());
		
		s
		
		for (int i=0;i<arr.size();i++){
			
			
			Class<?> el = arr.get(i);
			
			if (el!=null) {
				
				Class sClass = el.getSuperclass(); 
				
				arr.add(sClass);
				
				if (sClass!=null){
					
					
					Class[] arrayInterfaces = sClass.getInterfaces(); 
					
					
					for (int j=0;j<arrayInterfaces.length;j++){
						
						if (arrayInterfaces[i]!=null){
							
							System.out.println(arrayInterfaces[i]);
							
						}
						
					}
					
					
				}
				
			}
						
		}
		
	}

	
	public static void main(String[] args) {
		OutInterfacesOfObject(new HashMap<>());
	}

}
