package action06;

public class CarBuilderExample {
	public static void main(String[] args) {
		Car car1 = new BuilderCar().setColor("Black")
				.setNumber("AA 111").build();
		System.out.println(car1);

		
		BuilderCar config = new BuilderCar().setColor("Red");
		Car car2 = config.setNumber("2222").setMarka("KIA").build();
		
		System.out.println(car2); 		
	}	
}
class Car{

	public void setColor(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setMarka(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setNumber(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
class BuilderCar{
	private Car car;
	public BuilderCar setColor(String string) {
		car.setColor(string);
		return this;
	}

	public BuilderCar setMarka(String string) {
		car.setMarka(string);
		return this;
	}

	public Car build() {
		return car;
	}

	public BuilderCar setNumber(String string) {
		car.setNumber(string);
		return this;
	}
	
}