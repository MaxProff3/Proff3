package hw3;

public class CarBuilderExample {
	public static void main(String[] args) {
		Car car1 = new BuilderCar().setColor("Black").setNumber("AA 111").build();
		System.out.println(car1);
		System.out.println(car1.getColor() + ", " + car1.getNumber() + ", " + car1.getMarka());

		BuilderCar config = new BuilderCar().setColor("Red");
		Car car2 = config.setNumber("2222").setMarka("KIA").build();

		System.out.println(car2);
		System.out.println("config: " + config.getColor() + ", " + config.getNumber() + ", " + config.getMarka());
		System.out.println("car2: " + car2.getColor() + ", " + car2.getNumber() + ", " + car2.getMarka());

	}
}

class BuilderCar {

	private String color;
	private String number;
	private String marka;

	public Car build() {
		Car car = new Car();
		car.setColor(color);
		car.setNumber(number);
		car.setMarka(marka);
		return car;
	}

	public String getColor() {
		return color;
	}

	public BuilderCar setColor(String color) {
		this.color = color;
		return this;
	}

	public String getNumber() {
		return number;
	}

	public BuilderCar setNumber(String number) {
		this.number = number;
		return this;
	}

	public String getMarka() {
		return marka;
	}

	public BuilderCar setMarka(String marka) {
		this.marka = marka;
		return this;
	}

}

class Car {
	private String color;
	private String number;
	private String marka;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

}
