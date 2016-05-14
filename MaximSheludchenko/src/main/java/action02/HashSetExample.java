package action02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Car> set = new HashSet();
		  System.out.println(new Car("AA 1111","Black","MMM").hashCode());
		set.add(new Car("AA 1111","Black","MMM"));
		set.add(new Car("BB 2222", "White", "MMM"));
		set.add(new Car("CC 3333", "Red", "MMM"));
		set.add(new Car("DD 1111", "Black", "MMM"));
		set.add(new Car("FF 2222", "White", "MMM"));
		set.add(new Car("CC 3333", "Red", "MMM"));
		
		Iterator<Car> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().hashCode());
		}
		
	}
}
