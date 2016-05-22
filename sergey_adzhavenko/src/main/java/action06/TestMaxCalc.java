package action06;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestMaxCalc {
	
	@Test
	public void testEqully() {
		Calc calc = new Calc();
		calc.inChar('5');
		calc.inChar('5');
		calc.inChar('5');
		calc.inChar('+');
		calc.inChar('5');
		calc.inChar('=');
		if(!calc.getResult().equals("560")){
			fail("Result != 560");
		}
		Calc calc1 = new Calc();
		calc1.inChar('5');
		calc1.inChar('5');
		calc1.inChar('5');
		calc1.inChar('-');
		calc1.inChar('5');
		calc1.inChar('=');
		if(!calc1.getResult().equals("550")){
			fail("Result != 550");
		}
		Calc calc2 = new Calc();
		calc2.inChar('5');
		calc2.inChar('5');
		calc2.inChar('5');
		calc2.inChar('*');
		calc2.inChar('5');
		calc2.inChar('=');
		if(!calc2.getResult().equals("2775")){
			fail("Result != 2775");
		}
		Calc calc3 = new Calc();
		calc3.inChar('5');
		calc3.inChar('5');
		calc3.inChar('5');
		calc3.inChar('/');
		calc3.inChar('0');
		calc3.inChar('=');
		if(!calc3.getResult().equals(calc3.ByZero)){
			fail("Result != ByZero");
		}
		Calc calc4 = new Calc();
		calc4.inChar('0');
		calc4.inChar('/');
		calc4.inChar('9');
		calc4.inChar('=');
		if(!calc4.getResult().equals("0")){
			fail("Result != 0");
		}
		Calc calc5 = new Calc();
		calc5.inChar('/');
		calc5.inChar('9');
		calc5.inChar('=');
		if(!calc5.getResult().equals("0")){
			fail("Result != 0");
		}
	}
	
	@Test
	public void testSecondInt() {
		Calc calc = new Calc();
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
		Calc calc = new Calc();
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
		Calc calc = new Calc();
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
		Calc calc1 = new Calc();
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
