package action04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainCar {
	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<>();
		Car[] arr = new Car[10];

		Collections.sort(cars);
		Arrays.sort(arr);

		Collections.sort(cars, new CarComparator());
		Arrays.sort(arr, new CarComparator());
	}
}

class CarComparator implements Comparator<Car> {
	@Override
	public int compare(Car car1, Car car2) {
		return car1.getNumber().compareTo(car2.getNumber());
	}
}