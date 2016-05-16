package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;

import SecondWeek.AbstractCalc;
import SecondWeek.MyCalc;

public class AllMethods {
	
	
public static void main(String[] args) {
	/*
	Class<?> cl=String.class;
	Method [] methods =cl.getMethods();
	
	for(int i=0;i<methods.length;i++){
		System.out.println(methods[i]);
	}
	*/
	
	AllMethods all=new AllMethods();
	//all.getAll(ArrayList.class);
//	all.inter(ArrayList.class);
	
}

public void getAll(Class<?> class1){
	Class<?> cl=class1.getClass();
	
	Field[]f=cl.getDeclaredFields();
	for(int i=0;i<f.length;i++){
	System.out.println(f[i]);
	}
	
	Method [] m=cl.getDeclaredMethods();
	
	for(int j=0;j<m.length;j++){
		System.out.println(m[j]);
	}
	
	Class [] interf= cl.getInterfaces();
	for(int k=0;k<interf.length;k++){
		System.out.println(interf[k]);
	}
}

/*
public void Inter(Class<?> class1){
	Class<?> cl=class1;
	
	Class[] interfSup = cl.getSuperclass().getInterfaces();
	Class [] inter=cl.getInterfaces();
	
	for(int i=0;i<interfSup.length;i++){
		System.out.println(interfSup[i]);
	}
	for(int j=0;j<inter.length;j++){
		System.out.println(inter[j]);
	}
	
	
}
*/
/*
public void inter(Class<?> class1){
	Class<?> cl = class1;
	while(cl.){
		
	}
}
*/
}
