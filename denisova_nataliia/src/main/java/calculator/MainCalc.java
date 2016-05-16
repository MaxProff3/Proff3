package calculator;

public class MainCalc {
	public static void main(String[] args) {
		Calculator calc = new MyCalc();
		calc.inChar('1');
		calc.inChar('2');
		calc.inChar('+');
		calc.inChar('1');
		calc.inChar('0');
		calc.inChar('=');
		calc.printResult();

	}
}
