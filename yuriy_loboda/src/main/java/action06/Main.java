package action06;

public class Main {

	public static void main(String[] args) {
		Car car = new CarBuilder().setColor("Red").setMarka("Honda").setNumber("222").build();
			System.out.println(car.getColor());
	}

}
