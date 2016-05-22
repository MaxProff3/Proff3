package hwWeek2.myCalc;

public class MyCalc extends AbstractCalc {
	@Override
	public void inChar(char p) {

		int resultNow = 0;
		if (!Character.isDigit(p)) {
			if (p == '=') {
				if (operation == '/') {
					result = (resultNow == 0) ? ByZero : String.valueOf(methodCalc(temp, operation, resultNow));
				} else {
					result = String.valueOf(methodCalc(temp, operation, resultNow));
				}
				operation = ' ';
				temp = 0;
			} else {
				operation = p;
				temp = Integer.valueOf(result);
			}
		} else {
			if (!result.equals("") && resultNow == temp) {
				result = "";
			}
			if (resultNow == 0) {
				result = "" + p;
			} else {
				result += p;
			}
		}
	}

	public static int methodCalc(int a1, char op, int a2) {
		int res = 0;
		switch (op) {
		case '+':
			res = a1 + a2;
			break;
		case '-':
			res = a1 - a2;
			break;
		case '*':
			res = a1 * a2;
			break;
		case '/':
			res = a1 / a2;
			break;

		}
		return res;
	}
}
