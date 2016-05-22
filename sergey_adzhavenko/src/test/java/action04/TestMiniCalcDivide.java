package action04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniCalcDivide {

	@Test(expected=ArithmeticException.class)
	public void test() {
		MiniCalc calc = new MiniCalc();
		calc.divide(10, 10);
		
	}

}
