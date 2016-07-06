package homeWork3;

public class BuliderCar {
	private String color;
	private String number;
	private String marka;

	public static void main(String[] args) {
		Car car1 = new BuliderCar().setColor("Black").setNumber("AA 111").build();
		System.out.println(car1);

		BuliderCar config = new BuliderCar().setColor("Red");
		Car car2 = config.setNumber("2222").setMarka("KIA").build();
		System.out.println(car2);
	}

	public Car build() {
		return new Car(this);
	}

	public BuliderCar setMarka(String marka) {
		this.marka = marka;
		return this;
	}

	public BuliderCar setColor(String color) {
		this.color = color;
		return this;
	}

	public BuliderCar setNumber(String number) {
		this.number = number;
		return this;
	}

	public String getMarka() {
		return marka;
	}

	public String getColor() {
		return color;
	}

	public String getNumber() {
		return number;
	}
}

class Car {
	private String color;
	private String number;
	private String marka;

	public Car(BuliderCar builder) {
		this.color = builder.getColor();
		this.number = builder.getNumber();
		this.marka = builder.getMarka();
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

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

	@Override
	public String toString() {
		return "Car [color=" + color + ", name=" + number + ", marka=" + marka + "]";
	}

}
