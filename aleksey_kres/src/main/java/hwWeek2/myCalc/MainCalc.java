package hwWeek2.myCalc;

public class MainCalc {
	public static void main(String[] args) {
		Calculator calc = new MyCalc();
		/*calc.inChar('1');*/
		calc.inChar('2');
		/*calc.printResult();*/
		calc.inChar('*');
		calc.inChar('2');
		calc.inChar('=');
		calc.printResult();
		/*calc.inChar('4');
		calc.inChar('=');
		calc.printResult();
		*/
		
	}
}
