package action06_homework;

public class MainCalc {
	public static void main(String[] args) {
		Calculator calc = new Calc();
		String str = "0*002=";
		for(char p:str.toCharArray()){
			System.out.println("Input "+p);
			calc.inChar(p);
			System.out.println();
		}
	}
	
}

