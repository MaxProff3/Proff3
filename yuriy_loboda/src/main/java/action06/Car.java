package action06;

public class Car  {
	private String number;
	private String color;
	private String marka;
	private CarBuilder cb=new CarBuilder();
	
	 Car(){
     
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
