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
	private String number;
	private String color;
	private String marka;
	
	public Car(String number, String color, String marka) {
		this.number = number;
		this.color = color;
		this.marka = marka;
	}
	
}
class BuilderCar{
	private String number;
	private String color;
	private String marka;

	public BuilderCar setNumber(String number) {
		this.number = number;
		return this;
	}

	public BuilderCar setColor(String color) {
		this.color = color;
		return this;
	}

	public BuilderCar setMarka(String marka) {
		this.marka = marka;
		return this;
	}
	
	public Car build(){
		
		Car car=new Car(number,color,marka);	
		return car;
		
	}
	
}