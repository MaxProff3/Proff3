package action06;

public class CarBuilderExample {
		public static void main(String[] args) {
//			Car car1 = new BuilderCar().setColor("Black")
//					.setNumber("AA 111").build();
//			System.out.println(car1);
//
//			
//			BuilderCar config = new BuilderCar().setColor("Red");
//			Car car2 = config.setNumber("2222").setMarka("KIA").build();
//			
//			System.out.println(car2);		
		}	
	
	class Car{
		
		
	}
	class BuilderCar{
		String color;
		String number;
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
		String marka;
	}
}

