package hw1;

import java.util.ArrayList;
import java.util.Comparator;

public class MainListTest {

	public static void main(String[] args) {
		
		Car car1 = new Car(1234, "red");
		Car car2 = new Car(99999, "red");
		Car car3 = new Car(-45, "red");
		Car car4 = new Car(5, "red");
		Car car5 = new Car(66, "red");
		Car car6 = new Car(0, "red");
		Car car7 = new Car(901, "red");
		Car car8 = new Car(3, "red");
		Car car9 = new Car(70, "red");
		Car car10 = new Car(13, "red");
		
		MyArrayList<Car> cars = new MyArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
		cars.add(car8);
		cars.add(car9);
		cars.add(car10);
		ArrayList<Car> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		list.add(car9);
		list.add(car10);
		
		for(int i=0;i<list.size();i++)System.out.println(list.get(i));
		
		list.sort(new Car());
		System.out.println("Sorted:");
		for(int i=0;i<list.size();i++)System.out.println(list.get(i));
		
		System.out.println("My ArrayList:");
		for(int i=0;i<cars.size();i++)System.out.println(cars.get(i));
		
		cars.sort(new Car());
		System.out.println("Sorted:");
		for(int i=0;i<cars.size();i++)System.out.println(cars.get(i));
		
		/*
		MyArrayList<String> list = new MyArrayList<>();
		for(int i=0;i<1000; i++){
		list.add("value="+i);
		}
		
		for(int i=0;i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("size="+list.size());
		
		list.add(5,"?????????");
		for(int i=0;i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("size="+list.size());
		
		String[] ar = new String[1000];
		list.toArray(ar);
		
		for(int i=0;i<ar.length; i++){
			System.out.println("ar: "+ar[i]);
		}
		list.forEach((String s) -> System.out.println("forEach: "+s));
		*/
		
		
	}

}
class Car implements Comparator<Car>{
	int number;
	String color;
	public Car(int number, String color) {
		this.number = number;
		this.color = color;
	}
	public Car() {
	
	}
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + "]";
	}
	@Override
	public int compare(Car o1, Car o2) {
		return o1.number-o2.number;
	}
}