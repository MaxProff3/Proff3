package hw1;
/*Задача1. 
Целочисленный калькулятор:

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
При делении на 0 результат должен быть значение ByZero.*/

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyCalc {
	
	@Test
	public void testEqully() {
		MyCalc calc = new MyCalc();
		calc.inChar('5');
		calc.inChar('5');
		calc.inChar('5');
		calc.inChar('+');
		calc.inChar('5');
		calc.inChar('=');
		if(!calc.getResult().equals("560")){
			fail("Result != 560");
		}
		MyCalc calc1 = new MyCalc();
		calc1.inChar('5');
		calc1.inChar('5');
		calc1.inChar('5');
		calc1.inChar('-');
		calc1.inChar('5');
		calc1.inChar('=');
		if(!calc1.getResult().equals("550")){
			fail("Result != 550");
		}
		MyCalc calc2 = new MyCalc();
		calc2.inChar('5');
		calc2.inChar('5');
		calc2.inChar('5');
		calc2.inChar('*');
		calc2.inChar('5');
		calc2.inChar('=');
		if(!calc2.getResult().equals("2775")){
			fail("Result != 2775");
		}
		MyCalc calc3 = new MyCalc();
		calc3.inChar('5');
		calc3.inChar('5');
		calc3.inChar('5');
		calc3.inChar('/');
		calc3.inChar('0');
		calc3.inChar('=');
		if(!calc3.getResult().equals(calc3.ByZero)){
			fail("Result != ByZero");
		}
		MyCalc calc4 = new MyCalc();
		calc4.inChar('0');
		calc4.inChar('/');
		calc4.inChar('9');
		calc4.inChar('=');
		if(!calc4.getResult().equals("0")){
			fail("Result != 0");
		}
		MyCalc calc5 = new MyCalc();
		calc5.inChar('/');
		calc5.inChar('9');
		calc5.inChar('=');
		if(!calc5.getResult().equals("0")){
			fail("Result != 0");
		}
	}
	
	@Test
	public void testSecondInt() {
		MyCalc calc = new MyCalc();
		calc.inChar('1');
		calc.inChar('0');
		calc.inChar('5');
		calc.inChar('+');
		calc.inChar('0');
		calc.inChar('0');
		if(!calc.getResult().equals("0")){
			fail("Result != 0");
		}
		calc.inChar('5');
		if(!calc.getResult().equals("5")){
			fail("Result != 5");
		}	
	}
	
	@Test
	public void testOperation() {
		MyCalc calc = new MyCalc();
		calc.inChar('0');
		calc.inChar('9');
		calc.inChar('9');
		calc.inChar('9');
		calc.inChar('9');
		if(!calc.getResult().equals("9999")){
			fail("Result is not equals 9999!");
		}
		calc.inChar('=');
		calc.inChar('*');
		if(!calc.getResult().equals("9999")){
			fail("Result is not equals 9999!");
		}
		calc.inChar('+');
		if(!calc.getResult().equals("9999")){
			fail("Result is not equals 9999!");
		}
		calc.inChar('-');
		if(!calc.getResult().equals("9999")){
			fail("Result is not equals 9999!");
		}
		calc.inChar('/');
		if(!calc.getResult().equals("9999")){
			fail("Result is not equals 9999!");
		}
		calc.inChar('+');
		calc.inChar('1');
		calc.inChar('=');
		if(!calc.getResult().equals("10000")){
			fail("Result is not equals 10000!");
		}
	}
	
	@Test
	public void testFirstInt() {
		MyCalc calc = new MyCalc();
		for(int i=0;i<20;i++){
		calc.inChar('0');
			if(!calc.getResult().equals("0")){
				fail("Result != 0");
			}
			if(calc.getResult().length()!=1){
				fail("Result length is more than 1!");
			}
		}
		calc.inChar('0');
		calc.inChar('0');
		calc.inChar('0');
		calc.inChar('1');
		calc.inChar('0');
		if(!calc.getResult().equals("10")){
			fail("Result is not equals 10!");
		}
		MyCalc calc1 = new MyCalc();
		calc1.inChar('0');
		calc1.inChar('1');
		calc1.inChar('2');
		calc1.inChar('3');
		calc1.inChar('4');
		calc1.inChar('5');
		calc1.inChar('6');
		calc1.inChar('7');
		calc1.inChar('8');
		calc1.inChar('9');
		
		if(!calc1.getResult().equals("123456789")){
			fail("Result is not equals 123456789!");
		}
	}

}
