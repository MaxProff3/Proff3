//package action06;
//
//public class CarBuilderExample {
//	public static void main(String[] args) {
//		Car car1 = new BuilderCar().setColor("Black").setNumber("AA 111").build();
//		System.out.println(car1);
//
//		BuilderCar config = new BuilderCar().setColor("Red");
//		Car car2 = config.setNumber("2222").setMarka("KIA").build();
//
//		System.out.println(car2);
//	}
//}
//
//class BuilderCar {
//	private String color;
//	private String number;
//	private String marka;
//	
//	public Car build(){
//		return new Car(this);
//	}
//
//	public BuilderCar setMarka(String marka){
//		this.marka=marka;
//		return this;
//	}
//	
//	public BuilderCar setColor(String color){
//		this.color=color;
//		return this;
//	}
//	public BuilderCar setNumber(String number){
//		this.number=number;
//		return this;
//	}
//
//
//	public String getMarka() {
//		return marka;
//	}
//
//	public String getColor() {
//		return color;
//	}
//	
//	public String getNumber() {
//		return number;
//	}
//
//}
//
//class Car {
//	private String color;
//	private String number;
//	private String marka;
//	
//	public Car(BuilderCar builder){
//		this.color = builder.getColor();
//		this.number = builder.getNumber();
//		this.marka = builder.getMarka();
//	}
//
//	public String getMarka() {
//		return marka;
//	}
//
//	public void setMarka(String marka) {
//		this.marka = marka;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public String getNumber() {
//		return number;
//	}
//
//	public void setNumber(String number) {
//		this.number = number;
//	}
//
//	@Override
//	public String toString() {
//		return "Car [color=" + color + ", name=" + number + ", marka=" + marka + "]";
//	}
//
//}
