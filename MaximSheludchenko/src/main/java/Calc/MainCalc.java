/*Целочисленный калькулятор:

Создать целочисленный калькулятор класс Calc наследник AbstractCalc, в котором реализовать метод inChar
Вводимые символы такие: цифры, +, -, *, /, =
Будем считать, что ввод символов возможен только те, что мы определили - цифры, операции и равно.
Последовательность ввода такая: число1 + операция + число2 + равно.
Написать модульный тест для проверки:

1) корректного введения первого числа
2) корректного введения операции
3) корректного введения второго числа(проверка результирующего значения)
4) корректного введения знака "="(проверка результирующего значения)

Проверка при вводе чисел необходимо проверить следующее:
 - начинающихся с 0, должно быть преобразование и "0" не должен отображаться
 - результирующее поле должно соответсвовать набираемым символам
Проверка корректного ввода операции - это значит, что результирующее поле не изменилось.
При делении на 0 результат должен быть значение ByZero.
*/
package Calc;

public class MainCalc {
	public static void main(String[] args) {
		Calculator calc = new MyCalc();
		calc.inChar('3');
		calc.inChar('5');
		calc.inChar('*');
		calc.inChar('2');
		calc.inChar('9');
		calc.inChar('2');
		calc.inChar('-');
		calc.inChar('4');
		calc.inChar('3');
		calc.inChar('1');
		calc.inChar('/');
		calc.inChar('4');
		calc.inChar('7');
		calc.inChar('8');
		calc.inChar('=');
		
		//�������� ������ ������� �� 0
		//�������� ������� �����
		//��� ��������� � ������� ++++
		//�������� ��������
		
//		calc.inChar('6');
//		calc.inChar('4');
//		calc.inChar('+');
//		calc.inChar('2');
//		calc.inChar('=');
//		calc.inChar('=');
//		calc.inChar('=');
	}
}
