package action02;

public class MainCar {
	  public static void main(String[] args) {
		Car car1 = new Car("AA 1111","Black","mmm");
		Car car2 = new Car("AA 1111","Black","mmm");
		if(car1.equals(car2))System.out.println("Равны");
		else System.out.println("Разны");
	}	
}
