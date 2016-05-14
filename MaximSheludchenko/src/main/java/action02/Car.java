package action02;

public class Car {
	private String number;
	private String color;
	private String marka;
	
	public int hashCode(){//
		return number.hashCode();
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

	public Car(String number, String color, String marka) {
		super();
		this.number = number;
		this.color = color;
		this.marka = marka;
	}

	public Car() {
		super();
	}

	@Override
	 public boolean equals(Object obj){
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
}
