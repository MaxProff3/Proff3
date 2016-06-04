package action06;

public  class CarBuilder {
	private String number;
	private String color;
	private String marka;
	private Car car ;
	
	
	
	public Car build(){
		car = new Car();
		car.setColor(color);
		car.setMarka(marka);
		car.setNumber(number);
		return car;
		
	}
	public CarBuilder setColor(String color){
		this.color=color;
		return this;
	}
	public CarBuilder setMarka(String marka){
		this.marka=marka;
		return this;
	}
	
	public CarBuilder setNumber(String nomer){
		this.number=nomer;
		return this;
	}
	
}
