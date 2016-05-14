package mycalc;

public class Calc extends AbstractCalc {

	@Override
	public void inChar(char p) {

		int current = getIntRes();

		if (!Character.isDigit(p)) {
			if (p == '=') {
				if (operation == '/') {
					result = (current == 0) ? ByZero : String.valueOf(methodCalc(temp, current, operation));
				} else if (p == '+' || p == '-' || p == '*') {
					if(operation == p) {						
						result = String.valueOf(methodCalc(temp, current, operation));
					} else{
						result = String.valueOf(methodCalc(temp, current, operation));
					}
				}
				operation = ' ';
				temp = 0;
			} else {
				operation = p;
				temp = Integer.valueOf(result);
			}
		} else {
			if (getIntRes() != 0 && current == temp) {
				result = "";
			}
			if (current == 0) {
				result = "" + p;
			} else {
				result += p;
			}
		}
	}

	private int methodCalc(int a1, int a2, char op) {
		switch (op) {
		case '+':
			return a1 + a2;
		case '-':
			return a1 - a2;
		case '*':
			return a1 * a2;
		case '/':
			return a1 / a2;
		default:
			return 0;
		}
	}

}
