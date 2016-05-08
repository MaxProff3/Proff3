package calc;

public class MyCalc extends AbstractCalc {

	private boolean isOperationSet;

	@Override
	public void inChar(char p) {
		// Сброс калькулятора
		if (p == 67)
			clearCalc();

		if (result.equals(ByZero))
			return;

		// Ввод числа
		if (0 + p > 47 && 0 + p < 58) {
			if (result.equals("0") || (isOperationSet)) {
				result = "" + p;
				isOperationSet = false;
			} else
				result = result + p;
		}

		// Сложение
		if (p == 43) doCalc(43);

		// Умножение
		if (p == 42 || p == 1093) doCalc(42);

		// Деление
		if (p == 47 || p == 247) doCalc(47);

		// Вычитание
		if (p == 45)  doCalc(45);

		// Равно
		if (p == 61 && operation != 0)  doCalc(0);
		
		
	}

	private void doCalc(int command) {

		try {

			if (operation != 0 && (!isOperationSet||command==0)) {

				int value = Integer.parseInt(result);

				if (operation == 43) {
					result = "" + (temp + value);
				}
				if (operation == 45) {
					result = "" + (temp - value);
				}
				if (operation == 42) {
					result = "" + (temp * value);
				}
				if (operation == 47) {
					result = "" + (temp / value);
				}

			}
			
			temp = Integer.parseInt(result);
		} catch (Exception e) {
			result = ByZero;
		}
		
		operation = (char) command;
		isOperationSet = true;
	}

	public MyCalc() {
		clearCalc();
	}

	public void clearCalc() {
		result = "0";
		temp = 0;
		operation = 0;
		isOperationSet = false;
	}

}
