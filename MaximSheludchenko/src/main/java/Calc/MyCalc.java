package Calc;

public class MyCalc extends AbstractCalc {
	String tempResult = "";
	
	{
		result="";
	}

	@Override // 10+20+30+40=100
	public void inChar(char p) {
		if ((int) (p) > 47 && (int) (p) < 59) {
			tempResult = tempResult + p;
			result = tempResult;
		} else {
			if (p == '*' || p == '+' || p == '/' || p == '-') {
				if (operation == '*' || operation == '+' || operation == '/' || operation == '-') {
					Integer res = new Integer(tempResult);
					tempResult = "";
					switch (operation) {
					case '+':
						res = res + temp;
						break;
					case '-':
						res = temp - res;
						break;
					case '*':
						res = temp * res;
						break;
					case '/':
						res = temp / res;
						break;
					default:
						break;
					}
					operation = p;
					temp = res;
					result = "" + res;
				} else {
					operation = p;
					temp = new Integer(tempResult);
					tempResult = "";
					result = "" + temp;
				}
			} else if (p == '=') {
				Integer res = new Integer(tempResult);
				switch (operation) {
				case '+':
					res = res + temp;
					break;
				case '-':
					res = temp - res;
					break;
				case '*':
					res = temp * res;
					break;
				case '/':
					res = temp / res;
					break;
				default:
					break;
				}
				temp = res;				
				result = "" + res;
			}
		}
		System.out.print("Symvol: " + p +"    ");
		printResult();
		
	}

}
