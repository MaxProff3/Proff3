package action04;

public class Car implements Comparable<Car>{
	private String number;
	private String color;
	private String marka;
	
	@Override
	public int compareTo(Car car) {
		return this.number.compareTo(car.number);
	}		
	
	@Override
	public int hashCode(){
		return number.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		boolean a=(obj instanceof ProductShop);
		if(obj == null) return false;
		if(this == obj) return true;
		if(this.getClass() != obj.getClass()) return false;
		
		Car car = (Car)obj;
		
		boolean isEqualsColor = false;
		if(this.color==null && car.color==null)isEqualsColor=true;
		if(this.color!=null) isEqualsColor = this.color.equals(car.color);
		if(!isEqualsColor) return false;
		
		boolean isEqualsMarka = false;
		if(this.marka==null && car.marka==null)isEqualsMarka=true;
		if(this.marka!=null)isEqualsMarka= this.marka.equals(car.marka);

		return isEqualsMarka;
	}
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + ", marka=" + marka + "]";
	}
	public Car() {
	}
	
	public Car(String number) {
		this.number = number;
	}

	public Car(String number, String color, String marka) {
		this.number = number;
		this.color = color;
		this.marka = marka;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}


}	

