package action06;

public class BuilderCar {
	
	private  Car car;
	
	
	public void setColor(String color){
		car.setColor(color);

	}
	
	public void setNumber(String number){
		car.setNumber(number);
	
	}
	public void setMarka(String marka){
		car.setMarka(marka);
		
	}
	public Car build(){
		return car;
	}
	

}
