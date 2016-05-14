package hw1;

import java.util.HashSet;
import java.util.Set;

public class MainTestHashSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		MyHashSet<String> list = new MyHashSet<String>();
		
		set.add("sdf");
		set.add("afdgh");
		set.add("zsdfgh");
		set.add("1111");
		set.add("2222");
		set.add("sdf");
		set.add("sdf");

		
		list.add("sdf");
		list.add("afdgh");
		list.add("zsdfgh");
		list.add("1111");
		list.add("2222");
		list.add("sdf");
		list.add("sdf");
		for(int i=0;i<1000;i++){
			list.add("value="+i);
			set.add("value="+i);
		}
		for(int i=1000;i<2000;i++){
			list.add("value="+i);
			set.add("value="+i);
		}
		for(int i=0;i<1000;i++){
			list.add("ert");
			set.add("ert");
		}
		System.out.println("HashSet size:"+set.size());	
		System.out.println("HashSet:"+set.contains("1111"));
		
		System.out.println("MyHashSet size:"+list.size());
		System.out.println("MyHashSet:"+list.contains("1111"));
	}

}
