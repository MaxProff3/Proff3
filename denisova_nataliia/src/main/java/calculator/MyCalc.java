package calculator;

//Создать целочисленный калькулятор класс Calc 
//наследник AbstractCalc, в котором реализовать метод inChar
//Вводимые символы такие: цифры, +, -, *, /, =
//Будем считать, что ввод символов возможен только те, 
//что мы определили - цифры, операции и равно.
//Последовательность ввода такая: число1 + операция + число2 + равно.

public class MyCalc extends AbstractCalc {
	private String tempChar = "";
	private int temp = 0; // сохраняетя последнее введённое число
	private int priv = 0;

	@Override
	public void inChar(char p) {
		if (p == '1' || p == '2' || p == '3' || p == '4' || p == '5' || p == '6' || p == '7' || p == '8' || p == '9'
				|| p == '0') {

			tempChar += p;
			// System.out.println("tempChar = " + tempChar + " " + "temp = " +
			// temp);

		} else if (p == '+' || p == '-' || p == '*' || p == '/') {
			Integer i1 = new Integer(tempChar);// преобразовует число в int
			temp = i1;// отдаёт это число в temp
			tempChar = "";// обнуляем tempChar
			operation = p;// запоминаем действие

		} else if (p == '=') {
			Integer i1 = new Integer(tempChar);
			if (operation == '+') {
				result = Integer.toString(temp + i1);
				// priv = Integer.parseInt(result);

			} else if (operation == '-') {
				result = Integer.toString(temp - i1);

			} else if (operation == '*') {
				result = Integer.toString(temp * i1);

			} else if (operation == '/') {
				result = Integer.toString(temp / i1);
			}

		}

	}
}
